package com.biokes.apiBank.services.interfaces;

import com.biokes.apiBank.data.models.Track;

import java.util.List;

public interface AlbumTracksService {
    void persist(List<Track> albumTracks, String albumId);
    void wipe();
}
