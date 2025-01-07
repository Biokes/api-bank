package com.biokes.apiBank.controller;

import com.biokes.apiBank.dto.ApiResponse;
import com.biokes.apiBank.services.interfaces.AlbumService;
import com.biokes.apiBank.services.interfaces.AlbumTracksService;
import com.biokes.apiBank.services.interfaces.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/songs/")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;
    @GetMapping("localTrends")
    public ResponseEntity<?> getAllLocalTrends(){
        return ResponseEntity.status(OK).body(
                new ApiResponse(
                        true,
                        songService.getLocalTrends() == null || songService.getLocalTrends().isEmpty() ? "no data available" :  songService.getLocalTrends() ,
                        now())
        );
    }
    @GetMapping("globalTrends")
    public ResponseEntity<?> getAllGlobalTrends(){
        return  ResponseEntity.status(OK).body(
                new ApiResponse(
                        true,
                        songService.getGlobalTrends() == null || songService.getGlobalTrends().isEmpty() ? "no data available" :  songService.getLocalTrends() ,
                        now()
                        )
        );
    }
    @GetMapping("new-releases/albums")
    public ResponseEntity<?> getNewReleasedAlbum(){
        return ResponseEntity.status(OK).body(
                new ApiResponse(
                        true,
                        albumService.getLatestAlbum() == null || albumService.getLatestAlbum().isEmpty() ? "no data available" : albumService.getLatestAlbum(),
                        now()
                )
        );
    }
}
