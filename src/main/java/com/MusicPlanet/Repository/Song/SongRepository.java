package com.MusicPlanet.Repository.Song;

import com.MusicPlanet.DalInterfaces.ISongDal;
import com.MusicPlanet.Entities.Artist;
import com.MusicPlanet.Entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository implements ISongDal {

    @Autowired
    ISongRepository repository;

    public Optional<Song> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Song> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Song> findByTitleContaining(String title) {
        return repository.findSongByTitleContaining(title);
    }

    @Override
    public List<Song> findByArtistName(String name){ return repository.findSongsByArtists_NameContaining(name);}

    @Override
    public List<Song> findByArtistId(Long id){ return repository.findSongsByArtists_Id(id);}

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void save(Song song) {
        repository.save(song);
    }
}
