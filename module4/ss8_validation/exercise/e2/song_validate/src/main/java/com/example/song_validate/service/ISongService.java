package com.example.song_validate.service;

import com.example.song_validate.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();
    Optional<Song> findById(Long id);
    void save(Song song);
    void delete(Long id);
}
