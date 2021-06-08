package com.MusicPlanet.DalInterfaces;

import com.MusicPlanet.Entities.Playlist;
import com.MusicPlanet.Entities.Song;

import java.util.List;
import java.util.Optional;

public interface IPlaylistDal {

    Optional<Playlist> findById(Long id);

    List<Playlist> getAll();

    List<Playlist> findByNameContaining(String name);

    void deleteById(Long id);

    void deleteAll();

    void save(Playlist playlist);
}
