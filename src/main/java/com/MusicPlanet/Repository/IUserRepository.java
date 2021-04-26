package com.MusicPlanet.Repository;

import com.MusicPlanet.Entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User getUserById(int id);
}
