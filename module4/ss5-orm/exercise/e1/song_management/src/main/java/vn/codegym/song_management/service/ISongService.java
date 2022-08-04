package vn.codegym.song_management.service;

import vn.codegym.song_management.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    void update(Song song);
    void delete(int id);
    Song findById(int id);
}
