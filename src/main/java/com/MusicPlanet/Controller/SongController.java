package com.MusicPlanet.Controller;

import com.MusicPlanet.DTO.SongDTO;
import com.MusicPlanet.Entities.Artist;
import com.MusicPlanet.Entities.Song;
import com.MusicPlanet.Services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @CrossOrigin
    @GetMapping("")
    public List<Song> getAll(){
        return songService.getAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Song>> get(@PathVariable Long id){
        try{
            Optional<Song> song = songService.getById(id);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/title/{title}")
    public List<Song> getByTitle(@PathVariable("title") String title) {
        return songService.GetByTitle(title);
    }

    @CrossOrigin
    @GetMapping("/artist/name/{name}")
    public List<Song> getByArtistName(@PathVariable("name") String name) {
        return songService.GetByArtistName(name);
    }

    @CrossOrigin
    @GetMapping("/artist/id/{id}")
    public List<Song> getByArtistId(@PathVariable("id") Long id) {
        return songService.GetByArtistId(id);
    }

    @CrossOrigin
    @PostMapping("/")
    public void add(@RequestBody SongDTO songDTO){
        Song song = new Song(songDTO);
        songService.save(song);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Song song, @PathVariable Long id){
        try{
            Optional<Song> existSong = songService.getById(id);

            if(!existSong.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            song.setId(id);
            songService.save(song);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        songService.delete(id);
    }

    @CrossOrigin
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            songService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
