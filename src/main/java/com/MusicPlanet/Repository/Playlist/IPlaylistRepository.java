package com.MusicPlanet.Repository.Playlist;

import com.MusicPlanet.Entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findPlaylistByNameContaining(String name);
}
