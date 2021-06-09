package com.musicplanet.repository.Song;

import com.musicplanet.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ISongRepository extends JpaRepository<Song, Long> {
    List<Song> findSongByTitleContaining(String title);
    List<Song> findSongsByArtists_NameContaining(String name);
    List<Song> findSongsByArtists_Id(Long id);
}
