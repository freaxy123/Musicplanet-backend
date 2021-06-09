package com.musicplanet.repository.Artist;

import com.musicplanet.entities.Artist;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void getAll() {
        //Arrange
        List<Artist> artists = new ArrayList<>();

        //Act
        artists = artistRepository.getAll();

        //Assert
        Assert.isTrue(!artists.isEmpty());
    }

    @Test
    void findById() {
    }

    @Test
    void findByNameContaining() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void save() {
    }
}