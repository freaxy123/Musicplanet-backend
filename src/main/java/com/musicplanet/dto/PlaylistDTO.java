package com.musicplanet.dto;

import com.musicplanet.entities.Playlist;
import com.musicplanet.entities.Song;
import com.musicplanet.entities.User.Role;
import com.musicplanet.entities.User.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class PlaylistDTO {

    private Long id;
    public String name;

    private Collection<SongDTO> songs = new LinkedHashSet<>();;

    private String username;

    public PlaylistDTO(Playlist playlist) {
        this.id = playlist.getId();
        this.name = playlist.getName();

        for (Song song : playlist.getSongs()) {
            this.songs.add(new SongDTO(song));
        }

        this.username = playlist.getUser().getUsername();
    }
}
