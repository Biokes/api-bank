package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song,Long> {
}
