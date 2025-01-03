package com.biokes.apiBank.controller;

import com.biokes.apiBank.dto.ApiResponse;
import com.biokes.apiBank.services.interfaces.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/songs/")
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping("localTrends")
    public ResponseEntity<?> getAllLocalTrends(){
        return ResponseEntity.status(OK).body(
                new ApiResponse(
                        true,
                        songService.getLocalTrends() == null ? "no data available" :  songService.getLocalTrends() ,
                        LocalDateTime.now())
        );
    }
}
