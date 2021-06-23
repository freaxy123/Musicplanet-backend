package com.musicplanet.dto;

import com.musicplanet.entities.Artist;
import com.musicplanet.entities.Song;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class SongDTO {
    private Long id;
    private String title;

    private Collection<ArtistDTO> artists = new LinkedHashSet<>();

    public SongDTO(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.artists = artists;

        for (Artist artist : song.getArtists()) {
            this.artists.add(new ArtistDTO(artist));
        }
    }
}
