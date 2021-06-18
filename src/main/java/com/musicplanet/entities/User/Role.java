package com.musicplanet.entities.User;

import com.musicplanet.dto.RoleDTO;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(RoleDTO roleDTO) {
        this.id = roleDTO.getId();
        this.name = roleDTO.getName();
    }

    public Role() {

    }
}
