package com.biokes.apiBank.services.impl;

import com.biokes.apiBank.data.models.Song;
import com.biokes.apiBank.data.repositories.SongRepo;
import com.biokes.apiBank.services.interfaces.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiBankSongService implements SongService {
    @Autowired
    private SongRepo repo;
    @Override
    public List<Song> getLocalTrends() {
        return repo.findAll().stream()
                .filter(song-> !song.isGlobalSong())
                .collect(Collectors.toList());
    }
}
