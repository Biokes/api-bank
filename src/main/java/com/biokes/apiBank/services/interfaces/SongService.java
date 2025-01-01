package com.biokes.apiBank.services.interfaces;

import com.biokes.apiBank.data.models.Track;

import java.util.List;

public interface SongService {
    List<Track> getLocalTrends();
}
