package com.MusicPlanet.DalInterfaces;

import com.MusicPlanet.Entities.Artist;
import com.MusicPlanet.Entities.Song;

import java.util.List;
import java.util.Optional;

public interface ISongDal {

    Optional<Song> findById(Long id);

    List<Song> getAll();

    List<Song> findByTitleContaining(String title);

    List<Song> findByArtistName(String name);

    List<Song> findByArtistId(Long id);

    void deleteById(Long id);

    void deleteAll();

    void save(Song song);
}
