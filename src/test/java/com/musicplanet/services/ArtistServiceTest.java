package com.musicplanet.services;

import com.musicplanet.entities.Artist;
import com.musicplanet.repository.Artist.ArtistRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

    @Mock
    private ArtistRepository artistRepository;
    private ArtistService artistService;

    @BeforeEach
    void setUp(){
        artistService = new ArtistService(artistRepository);
    }

    @Test
    void canGetAllArtists() {
        //Arrange
        Artist artist1 = new Artist();
        artist1.setId(1L);
        artist1.setName("TestArtist");

        Artist artist2 = new Artist();
        artist2.setId(2L);
        artist2.setName("TestArtist2");

        Artist artist3 = new Artist();
        artist3.setId(3L);
        artist3.setName("TestArtist3");


        List<Artist> expected = new ArrayList<>();
        expected.add(artist1);
        expected.add(artist2);
        expected.add(artist3);

        given(artistRepository.getAll()).willReturn(expected);

        //Act
        List<Artist> actual = artistService.getAll();

        //Assert
        verify(artistRepository).getAll();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void canSaveArtist() {
        //Arrange
        Artist artist = new Artist();
        artist.setId(1L);
        artist.setName("TestArtist");

        //Act
        artistService.save(artist);

        //Assert
        ArgumentCaptor<Artist> artistArgumentCaptor = ArgumentCaptor.forClass(Artist.class);
        verify(artistRepository).save(artistArgumentCaptor.capture());
        Artist capturedArtist = artistArgumentCaptor.getValue();
        assertThat(capturedArtist).isEqualTo(artist);
    }

    @Test
    void canGetById() {
        //Arrange
        Artist artist1 = new Artist();
        artist1.setId(2L);
        artist1.setName("TestArtist2");

        Optional<Artist> expected = Optional.ofNullable(artist1);
        given(artistRepository.findById(2L)).willReturn(expected);

        //Act
        Optional<Artist> actual = artistService.getById(2L);

        //Assert
        verify(artistRepository).findById(2L);
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void canGetByName() {
        //Arrange
        Artist artist1 = new Artist();
        artist1.setId(2L);
        artist1.setName("Name");

        List<Artist> expected = new ArrayList<>();
        expected.add(artist1);
        given(artistRepository.findByNameContaining("name")).willReturn(expected);

        //Act
        List<Artist> actual = artistService.GetByName("name");

        //Assert
        verify(artistRepository).findByNameContaining("name");
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void delete() {
        //Arrange

        //Act
        artistService.delete(5L);

        //Assert
        verify(artistRepository).deleteById(5L);
    }

    @Test
    void deleteAll() {
        //Arrange

        //Act
        artistService.deleteAll();

        //Assert
        verify(artistRepository).deleteAll();
    }
}