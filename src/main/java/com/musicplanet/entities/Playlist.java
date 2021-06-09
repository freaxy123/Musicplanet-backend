package com.musicplanet.entities;

import com.musicplanet.dto.PlaylistDTO;
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
@Table(name="playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany()
    @JoinColumn(name = "song_id")
    private List<Song> songs;

    public Playlist(PlaylistDTO playlistDTO){
        this.id = playlistDTO.getId();
        this.name = playlistDTO.getName();

        this.songs = new ArrayList<>();
        for (SongDTO songDTO : playlistDTO.getSongs()) {
            this.songs.add(new Song(songDTO));
        }
    }
}
