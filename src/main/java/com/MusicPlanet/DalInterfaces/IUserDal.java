package com.MusicPlanet.DalInterfaces;

import com.MusicPlanet.Entities.User;
import java.util.List;

public interface IUserDal {
    User getUserById (int id);
    List<User> getAllUsers();
    void addUser(User user);
    void deleteUser(int id);
}
