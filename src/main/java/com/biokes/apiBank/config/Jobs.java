package com.biokes.apiBank.config;

import com.biokes.apiBank.data.models.Song;
import com.biokes.apiBank.services.interfaces.SongService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class Jobs {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SongService songService;

    @Value("${SONG_API_KEY}")
    private String songApiKey;
    @Value("${SONG_API_HOST}")
    private String songApiHost;
    @Scheduled(initialDelay = 0,cron = "0 12 * * * 4")
    public void getNigeriaTrendingSongsOfTheWeek() throws Exception {
        List<Song> songs = fetchSongs("https://spotify81.p.rapidapi.com/top_200_tracks?country=NG&period=weekly&date=%s");
        songService.persistLocalSongs(songs);
    }
    @Scheduled(initialDelay = 0, cron = "0 12 * * * 4")
    public void getTopChartTrend() throws Exception{
        List<Song> songs = fetchSongs("https://spotify81.p.rapidapi.com/top_200_tracks?country=GLOBAL&period=weekly&date=%s");
        songService.persistGlobalSongs(songs);
    }

    private List<Song> fetchSongs(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url, getMostRecentThursday())))
                .header("x-rapidapi-key", songApiKey)
                .header("x-rapidapi-host", songApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody =  response.body();
        return objectMapper.readValue(responseBody, new TypeReference<>(){});
    }
    public static LocalDate getMostRecentThursday() {
        LocalDate today = LocalDate.now();
        int daysToSubtract = (today.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue() + 7) % 7;
        if (daysToSubtract == 0) daysToSubtract = 7;
        return today.minusDays(daysToSubtract);
    }
}
