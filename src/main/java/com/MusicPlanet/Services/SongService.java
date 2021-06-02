package com.MusicPlanet.Services;

import com.MusicPlanet.Entities.Song;
import com.MusicPlanet.Repository.Song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public List<Song> getAll(){return songRepository.getAll();}
    public void save(Song song){songRepository.save(song);}
    public Optional<Song> getById(Long id){return songRepository.findById(id);}
    public List<Song> GetByTitle(String title){return songRepository.findByTitleContaining(title);}
    public void delete(Long id){songRepository.deleteById(id);}
    public void deleteAll(){songRepository.deleteAll();}
}
