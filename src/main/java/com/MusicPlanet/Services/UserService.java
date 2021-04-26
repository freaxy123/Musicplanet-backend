package com.MusicPlanet.Services;

import com.MusicPlanet.Repository.UserDalJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MusicPlanet.Entities.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDalJPA userRepository;

    //Create
    public void createUser(User user){
        userRepository.addUser(user);
    }

    //READ
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public User getUserById(int id){
        //return userRepository.getUserById(id).orElse(null);
        return userRepository.getUserById(id);
    }

    //UPDATE
    public void updateUser(User user){
        //Get existing user
        //User existingUser=userRepository.getUserById(user.getId()).orElse(null);
        User existingUser=userRepository.getUserById(user.getId());

        //Change existing User
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        //Save changes
        userRepository.addUser(existingUser);
    }

    //DELETE
    public String deleteUser(int id){
        userRepository.deleteUser(id);
        return "User Removed";
    }
}
