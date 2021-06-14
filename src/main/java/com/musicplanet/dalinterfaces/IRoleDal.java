package com.musicplanet.dalinterfaces;

import com.musicplanet.entities.User.Role;

import java.util.List;
import java.util.Optional;

public interface IRoleDal {

    Role findById(Long id);

    Role findByName(String name);

    List<Role> getAll();

    void deleteById(Long id);

    void deleteAll();

    void save(Role role);
}
