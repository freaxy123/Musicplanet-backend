package com.MusicPlanet.DalInterfaces;

import com.MusicPlanet.Entities.Artist;

import java.util.List;
import java.util.Optional;

public interface IArtistDal {
    List<Artist> getAll();

    Optional<Artist> findById(Long id);

    List<Artist> findByNameContaining(String name);

    void deleteById(Long id);

    void deleteAll();

    void save(Artist artist);
}
