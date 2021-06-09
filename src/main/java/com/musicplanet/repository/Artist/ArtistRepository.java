package com.musicplanet.repository.Artist;

import com.musicplanet.dalinterfaces.IArtistDal;
import com.musicplanet.entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository implements IArtistDal {

    @Autowired
    private IArtistRepository artistRepository;

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public List<Artist> findByNameContaining(String name) {
        return artistRepository.findArtistByNameContaining(name);
    }

    @Override
    public void deleteById(Long id) {
        artistRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        artistRepository.deleteAll();
    }

    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);
    }
}
