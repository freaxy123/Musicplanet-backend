package com.MusicPlanet.Repository.Playlist;

import com.MusicPlanet.DalInterfaces.IPlaylistDal;
import com.MusicPlanet.Entities.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlaylistRepository implements IPlaylistDal {

    @Autowired
    IPlaylistRepository repository;

    public Optional<Playlist> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Playlist> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Playlist> findByNameContaining(String name) {
        return repository.findPlaylistByNameContaining(name);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void save(Playlist playlist) {
        repository.save(playlist);
    }
}
