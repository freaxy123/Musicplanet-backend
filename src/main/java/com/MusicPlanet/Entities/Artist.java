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
@Table(name="artists")
public class Artist {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    public String name;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "song_id")
    private List<Song> songs;
}
