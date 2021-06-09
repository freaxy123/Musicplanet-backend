package com.musicplanet.controller;

import com.musicplanet.dto.ArtistDTO;
import com.musicplanet.entities.Artist;
import com.musicplanet.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @CrossOrigin
    @GetMapping("")
    public List<Artist> getAll(){return artistService.getAll();}

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Artist>> get(@PathVariable Long id){
        try{
            Optional<Artist> artist = artistService.getById(id);
            return new ResponseEntity<>(artist, HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @CrossOrigin
    @GetMapping("/name/{name}")
    public List<Artist> getByName(@PathVariable("name") String name) {
        return artistService.GetByName(name);
    }

    @CrossOrigin
    @PostMapping("/")
    public void add(@RequestBody ArtistDTO artistDTO){
        Artist artist = new Artist(artistDTO);
        artistService.save(artist);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody Artist artist, @PathVariable Long id){
        try{
            Optional<Artist> existArtist = artistService.getById(id);

            if(!existArtist.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            artist.setId(id);
            artistService.save(artist);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        artistService.delete(id);
    }

    @CrossOrigin
    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            artistService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
