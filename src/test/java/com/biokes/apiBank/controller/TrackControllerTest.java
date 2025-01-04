package com.biokes.apiBank.controller;

import com.biokes.apiBank.config.Jobs;
import com.biokes.apiBank.data.models.Track;
import com.biokes.apiBank.data.models.TrackWrap;
import com.biokes.apiBank.data.repositories.SongRepo;
import com.biokes.apiBank.dto.ApiResponse;
import com.biokes.apiBank.services.impl.ApiBankSongService;
import com.biokes.apiBank.services.interfaces.SongService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class TrackControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper  objectMapper;
    @Mock private Jobs mockedJobs;
    @Mock private SongRepo songRepo;
    @InjectMocks private SongService songService = new ApiBankSongService(songRepo);
    @InjectMocks private SongController songController = new SongController(songService);

    @Test void testUserCanFetchListOfTrendingSongs() throws Exception{
        doNothing().when(mockedJobs).getTopChartTrend();
        doNothing().when(mockedJobs).getNigeriaTrendingSongsOfTheWeek();
        when(songRepo.findAll()).thenReturn(new ArrayList<>());
        MvcResult result = mockMvc.perform(get("/api/v1/songs/localTrends")
                .contentType(APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        ApiResponse tracks = objectMapper.readValue(jsonResponse, ApiResponse.class);
        assertNotNull(tracks.getData());
        assertTrue(tracks.isSuccessful());
        assertEquals("no data available", tracks.getData().toString());
    }

}
