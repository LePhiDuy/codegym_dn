package vn.codegym.song_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.song_management.model.Song;
import vn.codegym.song_management.repository.ISongRepository;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void delete(int id) {
        songRepository.delete(id);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }
}
