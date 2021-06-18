package com.musicplanet.dto;

import com.musicplanet.entities.User.Role;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class RoleDTO {
    private Long id;
    private String name;

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.name = role.getName();
    }
}
