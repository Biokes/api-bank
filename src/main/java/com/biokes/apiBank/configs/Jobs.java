package com.biokes.apiBank.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Configuration
public class Jobs {
    @Value("${SONG_API_KEY}")
    private String songApiKey;
    @Value("${SONG_API_HOST}")
    private String songApiHost;
    @Scheduled(cron = "0 12 * * * 4")
    public void getNigeriaTrendingSongsOfTheWeek() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("https://spotify81.p.rapidapi.com/top_200_tracks?country=NG&period=weekly&date=%s", getMostRecentThursday())))
                .header("x-rapidapi-key", songApiKey)
                .header("x-rapidapi-host", songApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }
    public static LocalDate getMostRecentThursday() {
        LocalDate today = LocalDate.now();
        int daysToSubtract = (today.getDayOfWeek().getValue() - DayOfWeek.THURSDAY.getValue() + 7) % 7;
        if (daysToSubtract == 0) daysToSubtract = 7;
        return today.minusDays(daysToSubtract);
    }
}
