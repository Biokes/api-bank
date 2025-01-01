package com.biokes.apiBank.controller;

import com.biokes.apiBank.dto.ApiResponse;
import com.biokes.apiBank.services.interfaces.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/songs/")
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping("localTrends")
    public ResponseEntity<?> getAllLocalTrends(){
        ApiResponse response = new ApiResponse();
        response.setData(songService.getLocalTrends());
        response.setTimeStamp(LocalDateTime.now());
        response.setSuccessful(true);
        return ResponseEntity.status(OK).body(response);
    }
}
