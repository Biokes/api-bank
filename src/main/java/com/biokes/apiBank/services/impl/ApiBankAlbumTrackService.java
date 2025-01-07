package com.biokes.apiBank.services.impl;

import com.biokes.apiBank.data.models.Track;
import com.biokes.apiBank.data.repositories.AlbumTracksRepository;
import com.biokes.apiBank.services.interfaces.AlbumTracksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiBankAlbumTrackService implements AlbumTracksService {
    @Autowired
    private AlbumTracksRepository repo;
    @Override
    public void persist(List<Track> albumTracks, String albumId) {
        albumTracks.forEach(track -> {
            track.setAlbumId(albumId);
            repo.save(track);
        });
    }
    @Override
    public void wipe() {
        repo.deleteAll();
    }

}
