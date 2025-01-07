package com.biokes.apiBank.services.impl;

import com.biokes.apiBank.data.models.Album;
import com.biokes.apiBank.data.models.Artist;
import com.biokes.apiBank.data.repositories.AlbumRepository;
import com.biokes.apiBank.services.interfaces.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiBankAlbumService implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Override
    public void persistAlbum(List<Album> albums) {
        albumRepository.saveAll(albums);
    }

    @Override
    public List<Album> getLatestAlbum() {
        return albumRepository.findAll();
    }
}
