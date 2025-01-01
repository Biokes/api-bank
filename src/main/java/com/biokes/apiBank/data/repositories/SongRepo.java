package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Track,Long> {
}
