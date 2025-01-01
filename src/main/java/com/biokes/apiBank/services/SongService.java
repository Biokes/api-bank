package com.biokes.apiBank.services;

import com.biokes.apiBank.data.models.Song;

import java.util.List;

public interface SongService {
    List<Song> getLocalTrends();
}
