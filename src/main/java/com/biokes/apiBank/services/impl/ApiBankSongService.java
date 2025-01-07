package com.biokes.apiBank.services.impl;

import com.biokes.apiBank.data.models.Song;
import com.biokes.apiBank.data.models.TrackMetaData;
import com.biokes.apiBank.data.repositories.SongRepo;
import com.biokes.apiBank.data.repositories.TrackMetaDataRepository;
import com.biokes.apiBank.services.interfaces.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiBankSongService implements SongService {
    private final SongRepo repo;
    @Override
    public List<Song> getLocalTrends() {
        return repo.findAll().stream()
                .filter(Song::isLocalSong)
                .toList();
    }
    @Override
    public void persistLocalSongs(List<Song> songs) {
        List<Song> DbSongs = repo.findAll().stream().filter(Song::isLocalSong).toList();
        repo.deleteAll(DbSongs);
        songs.forEach(song -> {
            song.setLocalSong(true);
            repo.save(song);
        });
    }
    @Override
    public List<Song> getGlobalTrends() {
        return repo.findAll().stream()
                .filter(song -> !song.isLocalSong())
                .toList();
    }
    @Override
    public void persistGlobalSongs(List<Song> songs) {
        List<Song> DbSongs = repo.findAll().stream().filter(song -> !song.isLocalSong()).toList();
        repo.deleteAll(DbSongs);
        songs.forEach(song -> {
            song.setLocalSong(false);
            repo.save(song);
        });
    }


}
