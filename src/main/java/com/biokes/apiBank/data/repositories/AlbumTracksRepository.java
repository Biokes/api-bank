package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumTracksRepository extends JpaRepository<Track, String> {
}
