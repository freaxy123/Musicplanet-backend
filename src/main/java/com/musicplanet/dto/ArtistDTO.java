package com.musicplanet.dto;

import com.musicplanet.entities.Artist;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ArtistDTO {
    private Long id;
    public String name;

    public ArtistDTO(Artist artist) {
        this.id = artist.getId();
        this.name = artist.getName();
    }
}
