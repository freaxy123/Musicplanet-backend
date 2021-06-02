package com.MusicPlanet.Repository.Artist;

import com.MusicPlanet.Entities.Artist;
import com.MusicPlanet.Entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface IArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findArtistByNameContaining(String name);
}
