package com.musicplanet.services;

import com.musicplanet.entities.Song;
import com.musicplanet.repository.Song.SongRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAll(){return songRepository.getAll();}
    public void save(Song song){songRepository.save(song);}
    public Optional<Song> getById(Long id){return songRepository.findById(id);}
    public List<Song> GetByTitle(String title){return songRepository.findByTitleContaining(title);}
    public List<Song> GetByArtistName(String name){ return songRepository.findByArtistName(name);}
    public List<Song> GetByArtistId(Long id){ return songRepository.findByArtistId(id);}
    public void delete(Long id){songRepository.deleteById(id);}
    public void deleteAll(){songRepository.deleteAll();}
}
