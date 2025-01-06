package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, String> {
}
