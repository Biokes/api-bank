package com.biokes.apiBank.services.interfaces;

import com.biokes.apiBank.data.models.Album;

import java.util.List;

public interface AlbumService {
    void persistAlbum(List<Album> albums);

    List<Album> getLatestAlbum();
}
