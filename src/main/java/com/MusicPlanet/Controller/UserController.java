package com.MusicPlanet.Controller;

import com.MusicPlanet.Entities.User;
import com.MusicPlanet.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    //READ
    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        try{
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("user")
    public ResponseEntity<Object> getUserById(@RequestParam Integer id) {
        try{
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //CREATE
    @PostMapping
    public ResponseEntity createUser(@RequestBody User user){
        try{
            userService.createUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //UPDATE
    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody User user){
        try{
            userService.updateUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE
    @DeleteMapping
    public ResponseEntity<Object> deleteUser(@RequestParam Integer id){
        try{
            return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
