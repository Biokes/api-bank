package com.biokes.apiBank.data.repositories;

import com.biokes.apiBank.data.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongRepo extends JpaRepository<Song,Long> {
    @Query("DELETE FROM Song s WHERE s.isLocalSong = true")
    void deleteLocalSongs();
}
