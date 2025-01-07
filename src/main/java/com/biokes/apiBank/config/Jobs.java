package com.biokes.apiBank.config;

import com.biokes.apiBank.data.models.Album;
import com.biokes.apiBank.data.models.Song;
import com.biokes.apiBank.data.models.Track;
import com.biokes.apiBank.exception.ApiBankException;
import com.biokes.apiBank.services.interfaces.AlbumService;
import com.biokes.apiBank.services.interfaces.AlbumTracksService;
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
import static com.biokes.apiBank.exception.ApiBankExceptionMessages.SOMETHING_WENT_WRONG;

@Configuration
@Slf4j
public class Jobs {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SongService songService;
//    @Autowired
//    private AlbumService albumService;
//    @Autowired
//    private AlbumTracksService albumTracksService;

    @Value("${SONG_API_KEY}")
    private String songApiKey;
    @Value("${SONG_API_HOST}")
    private String songApiHost;
//    @Value("${SONG_RELEASE_API_HOST}")
//    private String songReleaseApiHost;
//    @Value("${SCRAPER_API_HOST}")
//    private String scraperApiHost;
    @Scheduled(initialDelay = 1000, fixedRate = 604800000)
    public void getNigeriaTrendingSongsOfTheWeek() throws Exception {
        try{
//            songService.deleteAllLocalSongs();
            log.info("\n===============Getting the trends of Nigeria for the week==================\n");
            List<Song> songs = fetchSongs("https://spotify81.p.rapidapi.com/top_200_tracks?country=NG&period=weekly&date=%s");
            songService.persistLocalSongs(songs);
        }catch (Exception e) {
            log.info("\nCause of error ============> {}\n", e.getMessage());
            log.info("\nCause of error ============> {}\n", Arrays.toString(e.getStackTrace()));
            throw new ApiBankException(SOMETHING_WENT_WRONG.getMessage());
        }
    }
    @Scheduled(initialDelay = 1000, fixedRate = 604800000)
    public void getTopChartTrend() throws Exception {
        try {
            log.info("\n===============Getting the trends of Globe for the week==================\n");
            List<Song> songs = fetchSongs("https://spotify81.p.rapidapi.com/top_200_tracks?country=GLOBAL&period=weekly&date=%s");
            songService.persistGlobalSongs(songs);
        } catch (Exception e) {
            log.info("\nCause of error ============> {}\n", e.getMessage());
            log.info("\nCause of error ============> {}\n", Arrays.toString(e.getStackTrace()));
            throw new ApiBankException(SOMETHING_WENT_WRONG.getMessage());
        }
    }
//    @Scheduled(initialDelay = 0, fixedRate = 604800000)
//    public void getLatestAlbumReleases()throws Exception{
//        try{
//            albumTracksService.wipe();
//            log.info("\n===============Getting the newest releases of Nigeria for the week==================\n");
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create("https://spotify117.p.rapidapi.com/new_releases/?country=NG"))
//                    .header("x-rapidapi-key", songApiKey)
//                    .header("x-rapidapi-host", songReleaseApiHost)
//                    .method("GET", HttpRequest.BodyPublishers.noBody())
//                    .build();
//            List<Album> albums = getAlbums(request);
//            albums.forEach(album -> {
//                try {
//                    log.info("\n===============album to find track = {}", album);
//                    getAlbumTracks(album.getSpotifyId());
//                } catch (Exception e) {
//                    log.info("Cause of error ============> {}", e.getMessage());
//                    log.info("Cause of error ============> {}", Arrays.toString(e.getStackTrace()));
//                    throw new RuntimeException(e);
//                }
//            });
//        }
//        catch (Exception e) {
//            log.info("\nCause of error ============> {}\n", e.getMessage());
//            log.info("\nCause of error ============> {}\n", Arrays.toString(e.getStackTrace()));
//                throw new ApiBankException(SOMETHING_WENT_WRONG.getMessage());
//            }
//    }
//    private List<Album> getAlbums(HttpRequest request) throws IOException, InterruptedException {
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        log.info("\nresponse ===> {}\n", response);
//        var body = response.body();
//        JsonNode node = objectMapper.readTree(body).path("albums").path("items");
//        List<Album> albums = objectMapper.convertValue(node,new TypeReference<>(){});
//        albumService.persistAlbum(albums);
//        return albums;
//    }
//
//    public void getAlbumTracks(String albumId) throws Exception {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(String.format("https://spotify-scraper.p.rapidapi.com/v1/album/tracks?albumId=%s&limit=100",albumId)))
//                .header("x-rapidapi-key", songApiKey)
//                .header("x-rapidapi-host", scraperApiHost)
//                .method("GET", HttpRequest.BodyPublishers.noBody())
//                .build();
//        try{
//            persistTracksWithAlbumIdAndResponse(albumId, request);
//        }catch (Exception e) {
//            log.info("\nCause of error ============> {}\n", e.getMessage());
//            throw new ApiBankException(SOMETHING_WENT_WRONG.getMessage());
//        }
//    }
//    private void persistTracksWithAlbumIdAndResponse(String albumId, HttpRequest request) throws IOException, InterruptedException {
//        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        JsonNode node = objectMapper.readTree(response.body()).path("tracks").path("items");
//        List<Track> albumTracks = objectMapper.convertValue(node, new TypeReference<>(){});
//        albumTracksService.persist(albumTracks, albumId);
//    }
    private List<Song> fetchSongs(String url) throws Exception{
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format(url, getMostRecentThursday())))
                    .header("x-rapidapi-key", songApiKey)
                    .header("x-rapidapi-host", songApiHost)
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            return getSongs(responseBody);
        } catch (Exception e) {
            log.info("\nCause of error ============> {}\n", e.getMessage());
            log.info("\nCause of error ============> {}\n", Arrays.toString(e.getStackTrace()));
            throw new ApiBankException(SOMETHING_WENT_WRONG.getMessage());
        }
    }
    private List<Song> getSongs(String responseBody) throws ApiBankException {
        try{
            return objectMapper.readValue(responseBody, new TypeReference<>(){});
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
