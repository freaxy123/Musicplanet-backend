package com.musicplanet.dto;

import com.musicplanet.entities.User.Role;
import com.musicplanet.entities.User.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private Boolean locked = false;
    private Boolean enabled = false;
    private Collection<Role> roles = new LinkedHashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.locked = user.getLocked();
        this.enabled = user.getEnabled();
        this.roles = user.getRoles();
    }
}
