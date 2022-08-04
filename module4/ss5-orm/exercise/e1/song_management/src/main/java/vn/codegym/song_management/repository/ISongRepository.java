package vn.codegym.song_management.repository;

import vn.codegym.song_management.model.Song;

import java.util.List;

public interface ISongRepository {
    List<Song> findAll();
    void save(Song song);
    void update(Song song);
    void delete(int id);
    Song findById(int id);
}
