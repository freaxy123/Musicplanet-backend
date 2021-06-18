package com.musicplanet.dto;

import com.musicplanet.entities.User.Role;
import com.musicplanet.entities.User.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean enabled;
    private Collection<RoleDTO> roles = new LinkedHashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.locked = user.getLocked();
        this.enabled = user.getEnabled();

        for (Role role :user.getRoles()) {
            this.roles.add(new RoleDTO(role));
        }
    }
}
