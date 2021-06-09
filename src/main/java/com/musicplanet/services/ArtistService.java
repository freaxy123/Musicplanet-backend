package com.musicplanet.services;

import com.musicplanet.entities.Artist;
import com.musicplanet.repository.Artist.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAll(){return artistRepository.getAll();}
    public void save(Artist artist){artistRepository.save(artist);}
    public Optional<Artist> getById(Long id){return artistRepository.findById(id);}
    public List<Artist> GetByName(String name){return artistRepository.findByNameContaining(name);}
    public void delete(Long id){artistRepository.deleteById(id);}
    public void deleteAll(){artistRepository.deleteAll();}
}
