package com.MusicPlanet.Entities.Authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserAuthenticationResponse {
    private final String jwt;
}
