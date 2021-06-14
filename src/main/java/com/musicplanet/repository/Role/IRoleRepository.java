package com.musicplanet.repository.Role;

import com.musicplanet.entities.User.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
