package com.MusicPlanet.DalInterfaces;

import com.MusicPlanet.Entities.User.User;
import java.util.List;
import java.util.Optional;

public interface IUserDal {
    Optional<User> getById (int id);
    List<User> getAll();
    void save(User user);
    void delete(int id);

    Optional<User> getByEmail(String email);
    Optional<User> getByUsername(String username);
    int enable(String email);
}
