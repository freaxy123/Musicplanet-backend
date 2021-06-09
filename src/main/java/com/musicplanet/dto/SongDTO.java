package com.musicplanet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SongDTO {
    private Long id;
    private String title;

    private List<ArtistDTO> artists;
}
