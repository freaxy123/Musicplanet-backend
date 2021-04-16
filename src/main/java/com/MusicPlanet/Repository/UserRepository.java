package com.MusicPlanet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MusicPlanet.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
