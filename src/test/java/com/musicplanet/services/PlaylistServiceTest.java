package com.musicplanet.services;

import com.musicplanet.entities.Artist;
import com.musicplanet.entities.Playlist;
import com.musicplanet.repository.Artist.ArtistRepository;
import com.musicplanet.repository.Playlist.PlaylistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
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
class PlaylistServiceTest {

    @Mock
    private PlaylistRepository playlistRepository;
    private PlaylistService playlistService;

    @BeforeEach
    void setUp(){
        playlistService = new PlaylistService(playlistRepository);
    }

    @Test
    void getAll() {
        //Arrange
        Playlist playlist = new Playlist();
        playlist.setId(1L);
        playlist.setName("TestArtist");

        Playlist playlist1 = new Playlist();
        playlist1.setId(2L);
        playlist1.setName("TestArtist2");

        Playlist playlist2 = new Playlist();
        playlist2.setId(3L);
        playlist2.setName("TestArtist3");


        List<Playlist> expected = new ArrayList<>();
        expected.add(playlist);
        expected.add(playlist1);
        expected.add(playlist2);

        given(playlistRepository.getAll()).willReturn(expected);

        //Act
        List<Playlist> actual = playlistService.getAll();

        //Assert
        verify(playlistRepository).getAll();
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void save() {
        //Arrange
        Playlist playlist = new Playlist();
        playlist.setId(1L);
        playlist.setName("TestArtist");

        //Act
        playlistService.save(playlist);

        //Assert
        ArgumentCaptor<Playlist> playlistArgumentCaptor = ArgumentCaptor.forClass(Playlist.class);
        verify(playlistRepository).save(playlistArgumentCaptor.capture());
        Playlist capturedplaylist = playlistArgumentCaptor.getValue();
        assertThat(capturedplaylist).isEqualTo(playlist);
    }

    @Test
    void getById() {
        //Arrange
        Playlist playlist = new Playlist();
        playlist.setId(1L);
        playlist.setName("TestArtist");

        Optional<Playlist> expected = Optional.ofNullable(playlist);
        given(playlistRepository.findById(2L)).willReturn(expected);

        //Act
        Optional<Playlist> actual = playlistService.getById(2L);

        //Assert
        verify(playlistRepository).findById(2L);
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void getByUserId() {
    }

    @Test
    void getByUsername() {
    }

    @Test
    void getByName() {
        //Arrange
        Playlist playlist = new Playlist();
        playlist.setId(1L);
        playlist.setName("TestArtist");

        List<Playlist> expected = new ArrayList<>();
        expected.add(playlist);
        given(playlistRepository.findByNameContaining("name")).willReturn(expected);

        //Act
        List<Playlist> actual = playlistService.GetByName("name");

        //Assert
        verify(playlistRepository).findByNameContaining("name");
        assertThat(expected.equals(actual)).isTrue();
    }

    @Test
    void delete() {
        //Arrange

        //Act
        playlistService.delete(5L);

        //Assert
        verify(playlistRepository).deleteById(5L);
    }

    @Test
    void deleteAll() {
        //Arrange

        //Act
        playlistService.deleteAll();

        //Assert
        verify(playlistRepository).deleteAll();
    }
}