package com.biokes.apiBank.controller;

import com.biokes.apiBank.dto.ApiResponse;
import com.biokes.apiBank.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@Component
@RequestMapping("/api/v1/songs/")
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping("localTrends")
    public ResponseEntity<?> getAllLocalTrends(){
        return ResponseEntity.status(OK).body(new ApiResponse(true, songService.getLocalTrends(), LocalDateTime.now()));
    }
}
