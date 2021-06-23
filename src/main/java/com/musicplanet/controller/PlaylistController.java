package com.musicplanet.controller;

import com.musicplanet.dto.PlaylistDTO;
import com.musicplanet.dto.SongDTO;
import com.musicplanet.entities.Playlist;
import com.musicplanet.entities.Song;
import com.musicplanet.entities.User.User;
import com.musicplanet.services.PlaylistService;
import com.musicplanet.services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping("")
    public List<Playlist> getAll(){
        return playlistService.getAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDTO> get(@PathVariable Long id){

        try{
            Optional<Playlist> playlist = playlistService.getById(id);
            return new ResponseEntity<>(new PlaylistDTO(playlist.get()), HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        /*
        System.out.println("IOASMFIAMNSIFMASUIFNUI" + id);
        return new ResponseEntity<>(null, HttpStatus.OK);
        */

    }

    @CrossOrigin
    @GetMapping("/userid/{id}")
    public ResponseEntity<List<PlaylistDTO>> getByUserId(@PathVariable Long id){
        try{
            List<Playlist> playlist = playlistService.getByUserId(id);

            List<PlaylistDTO> playlists = new ArrayList<>();

            for (Playlist loop: playlist) {
                playlists.add(new PlaylistDTO(loop));
            }
            return new ResponseEntity<>(playlists, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/username/{username}")
    public ResponseEntity<List<PlaylistDTO>> getByUsername(@PathVariable String username){
        try{
            System.out.println("Username: " + username);
            List<Playlist> playlist = playlistService.getByUsername(username);

            List<PlaylistDTO> playlists = new ArrayList<>();

            for (Playlist loop: playlist) {
                playlists.add(new PlaylistDTO(loop));
            }


            return new ResponseEntity<>(playlists, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/name/{name}")
    public List<Playlist> getByName(@PathVariable("name") String name) {
        return playlistService.GetByName(name);
    }

    @CrossOrigin
    @PostMapping("/")
    public void add(@RequestBody PlaylistDTO playlistDTO){

        Playlist playlist = new Playlist();
        playlist.setId(playlistDTO.getId());
        playlist.setName(playlistDTO.getName());

        List<Song> songs = new ArrayList<>();
        for (SongDTO songDTO : playlistDTO.getSongs()) {
            songs.add(new Song(songDTO));
        }
        playlist.setSongs(songs);

        User user = userService.getByUsername(playlistDTO.getUsername()).get();
        playlist.setUser(user);
                playlistService.save(playlist);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody PlaylistDTO playlistDTO, @PathVariable Long id){
        try{
            Optional<Playlist> existPlaylist = playlistService.getById(id);

            if(!existPlaylist.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            playlistDTO.setId(id);
            Playlist playlist = new Playlist(playlistDTO);
            playlist.setUser(userService.getByUsername(playlistDTO.getUsername()).get());
            playlistService.save(playlist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        playlistService.delete(id);
    }

    @CrossOrigin
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            playlistService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
