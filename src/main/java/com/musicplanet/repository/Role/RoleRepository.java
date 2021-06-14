package com.musicplanet.repository.Role;

import com.musicplanet.dalinterfaces.IRoleDal;
import com.musicplanet.entities.Song;
import com.musicplanet.entities.User.Role;
import com.musicplanet.repository.Song.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleRepository implements IRoleDal {

    @Autowired
    IRoleRepository repository;

    public Role findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Role> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void save(Role role) {
        repository.save(role);
    }
}
