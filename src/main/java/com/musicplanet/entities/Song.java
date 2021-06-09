package com.musicplanet.entities;

import com.musicplanet.dto.ArtistDTO;
import com.musicplanet.dto.SongDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name="songs")
public class Song {


    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "song_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long id;
    private String title;

    /*@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})*/
    @ManyToMany()
    @JoinColumn(name = "artist_id")
    private List<Artist> artists;

    public Song(SongDTO songDTO) {
        this.id = songDTO.getId();
        this.title = songDTO.getTitle();

        this.artists = new ArrayList<Artist>();

        for (ArtistDTO artistDTO: songDTO.getArtists()) {
            this.artists.add(new Artist(artistDTO));
        }
    }
}
