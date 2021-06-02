package com.MusicPlanet.Controller;

import com.MusicPlanet.Entities.Song;
import com.MusicPlanet.Services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @CrossOrigin
    @GetMapping("")
    public List<Song> getAll(){return songService.getAll();}

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
    @PostMapping("/")
    public void add(@RequestBody Song song){
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
