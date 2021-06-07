package com.MusicPlanet.Services;

import com.MusicPlanet.Entities.Playlist;
import com.MusicPlanet.Entities.Song;
import com.MusicPlanet.Repository.Playlist.PlaylistRepository;
import com.MusicPlanet.Repository.Song.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> getAll(){return playlistRepository.getAll();}
    public void save(Playlist playlist){playlistRepository.save(playlist);}
    public Optional<Playlist> getById(Long id){return playlistRepository.findById(id);}
    public List<Playlist> GetByName(String name){return playlistRepository.findByNameContaining(name);}
    public void delete(Long id){playlistRepository.deleteById(id);}
    public void deleteAll(){playlistRepository.deleteAll();}
}
