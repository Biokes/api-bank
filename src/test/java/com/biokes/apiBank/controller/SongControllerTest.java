package com.biokes.apiBank.controller;

import com.biokes.apiBank.data.models.Song;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class SongControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper  objectMapper;
    @Test
    void testUserCanFetchListOfTrendingSongs() throws Exception{
        MvcResult result = mockMvc.perform(get("/api/v1/songs/localTrends")
                .contentType(APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        String jsonResponse = result.getResponse().getContentAsString();
        List<Song> songs = objectMapper.readValue(jsonResponse, new TypeReference<List<Song>>() {});
        assertNotNull(songs);
    }

}
