package com.biokes.apiBank.services.interfaces;

import com.biokes.apiBank.data.models.Song;

import java.util.List;

public interface SongService {
    List<Song> getLocalTrends();
    void persistLocalSongs(List<Song> songs);
    List<Song> getGlobalTrends();
    void persistGlobalSongs(List<Song> songs);
}
