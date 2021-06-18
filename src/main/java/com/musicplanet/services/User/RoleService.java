package com.musicplanet.services.User;

import com.musicplanet.entities.Artist;
import com.musicplanet.entities.User.Role;
import com.musicplanet.repository.Artist.ArtistRepository;
import com.musicplanet.repository.Role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){return roleRepository.getAll();}
    public void save(Role role){roleRepository.save(role);}
    public void delete(Long id){roleRepository.deleteById(id);}
    public void deleteAll(){roleRepository.deleteAll();}
}
