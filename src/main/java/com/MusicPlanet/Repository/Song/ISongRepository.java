package com.MusicPlanet.Repository.Song;

import com.MusicPlanet.Entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ISongRepository extends JpaRepository<Song, Long> {
    List<Song> findSongByTitleContaining(String title);
}
