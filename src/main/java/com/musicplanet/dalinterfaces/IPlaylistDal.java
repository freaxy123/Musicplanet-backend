package com.musicplanet.dalinterfaces;

import com.musicplanet.entities.Playlist;

import java.util.List;
import java.util.Optional;

public interface IPlaylistDal {

    Optional<Playlist> findById(Long id);

    List<Playlist> getAll();

    List<Playlist> findByNameContaining(String name);

    void deleteById(Long id);

    void deleteAll();

    void save(Playlist playlist);

    List<Playlist> findByUserId(Long id);
    List<Playlist> findByUsername(String username);
}
