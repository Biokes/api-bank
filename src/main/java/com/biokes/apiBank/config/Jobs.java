package com.biokes.apiBank.config;

import com.biokes.apiBank.data.models.Song;
import com.biokes.apiBank.data.models.Track;
import com.biokes.apiBank.exception.ApiBankException;
import com.biokes.apiBank.services.interfaces.SongService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Arrays;
import java.util.List;

import static com.biokes.apiBank.exception.ApiBankExceptionMessages.INVALID_MAPPING;

@Configuration
@Slf4j
public class Jobs {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SongService songService;

    @Value("${SONG_API_KEY}")
    private String songApiKey;
    @Value("${SONG_API_HOST}")
    private String songApiHost;
    @Scheduled(initialDelay = 1000, fixedRate = 604800000)
    public void getNigeriaTrendingSongsOfTheWeek() throws Exception {
        log.info("cron is about to run ====> Nigeria trends");
        List<Song> songs = fetchSongs("https://spotify81.p.rapidapi.com/top_200_tracks?country=NG&period=weekly&date=%s");
        log.info("cron is about to persist ====> local trends");
        songService.persistLocalSongs(songs);
    }
    @Scheduled(initialDelay = 1000, fixedRate = 604800000)
    public void getTopChartTrend() throws Exception{
        log.info("cron is about to run====> global trends");
        List<Song> songs = fetchSongs("https://spotify81.p.rapidapi.com/top_200_tracks?country=GLOBAL&period=weekly&date=%s");
        log.info("cron is about to persist ====> global trends");
        songService.persistGlobalSongs(songs);
    }
    private List<Song> fetchSongs(String url) throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format(url, getMostRecentThursday())))
                .header("x-rapidapi-key", songApiKey)
                .header("x-rapidapi-host", songApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody =  response.body();
        return getSongs(responseBody);
    }

    private List<Song> getSongs(String responseBody) throws ApiBankException {
        try{
            log.info("Response about to be mapped  =============>> {}",responseBody);
//            jsonNode = objectMapper.readTree(responseBody);
            return objectMapper.readValue(responseBody, new TypeReference<List<Song>>() {});
//            jsonNode = jsonNode.path("albums").get(0).path("tracks").path("items");
        }catch(JsonProcessingException exception){
            throw new ApiBankException(String.format("%s \n %s", INVALID_MAPPING.getMessage(), Arrays.toString(exception.getStackTrace())));
        }
    }

    public static LocalDate getMostRecentThursday() {
        LocalDate today = LocalDate.now();
        int daysToSubtract = (today.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue() + 7) % 7;
        if (daysToSubtract == 0) daysToSubtract = 7;
        return today.minusDays(daysToSubtract);
    }
}
