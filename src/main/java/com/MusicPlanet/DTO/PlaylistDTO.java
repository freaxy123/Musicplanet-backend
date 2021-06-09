package com.MusicPlanet.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlaylistDTO {

    private Long id;
    public String name;

    private List<SongDTO> songs;
}
