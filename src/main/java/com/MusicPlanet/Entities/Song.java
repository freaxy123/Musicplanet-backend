package com.MusicPlanet.Entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

}
