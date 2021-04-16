package com.MusicPlanet.Services;

import com.MusicPlanet.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MusicPlanet.Entities.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Create
    public User createUser(User user){
        return userRepository.save(user);
    }

    //READ
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    //UPDATE
    public User updateUser(User user){
        //Get existing user
        User existingUser=userRepository.findById(user.getId()).orElse(null);

        //Change existing User
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        //Save changes
        return userRepository.save(existingUser);
    }

    //DELETE
    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User Removed";
    }
}
