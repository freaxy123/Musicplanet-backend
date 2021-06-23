package com.musicplanet.repository.Playlist;

import com.musicplanet.entities.Playlist;
import com.musicplanet.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface IPlaylistRepository extends JpaRepository<Playlist, Long> {
    List<Playlist> findPlaylistByNameContaining(String name);
    List<Playlist> findPlaylistByUser_Id(Long userid);
    List<Playlist> findPlaylistByUser_username(String username);
}
