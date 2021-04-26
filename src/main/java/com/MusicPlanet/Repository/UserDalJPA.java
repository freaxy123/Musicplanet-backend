package com.MusicPlanet.Repository;

import com.MusicPlanet.DalInterfaces.IUserDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.MusicPlanet.Entities.User;
import java.util.List;

@Repository
public class UserDalJPA implements IUserDal {

    @Autowired
    IUserRepository repo;

    @Override
    public User getUserById(int id) {
        return repo.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    @Override
    public void addUser(User user) {
        repo.save(user);
    }

    @Override
    public void deleteUser(int id){
        repo.delete(repo.getUserById(id));
    }

}
