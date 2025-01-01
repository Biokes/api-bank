package com.biokes.apiBank.services.impl;

import com.biokes.apiBank.data.models.Song;
import com.biokes.apiBank.services.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiBankSongService implements SongService {

    @Override
    public List<Song> getLocalTrends() {
        return null;
    }
}
