package com.musicplanet.entities;

import com.musicplanet.dto.ArtistDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name="artists")
public class Artist {

    @SequenceGenerator(
            name = "artist_sequence",
            sequenceName = "artist_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "artist_sequence"
    )
    private Long id;
    public String name;

    public Artist(ArtistDTO artistDTO) {
        this.id = artistDTO.getId();
        this.name = artistDTO.getName();
    }
}
