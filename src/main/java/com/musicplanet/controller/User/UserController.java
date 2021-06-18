package com.musicplanet.controller.User;

import com.musicplanet.dto.ArtistDTO;
import com.musicplanet.dto.RoleDTO;
import com.musicplanet.dto.UserDTO;
import com.musicplanet.entities.Artist;
import com.musicplanet.entities.User.Role;
import com.musicplanet.entities.User.User;
import com.musicplanet.services.User.RoleService;
import com.musicplanet.services.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @CrossOrigin
    @GetMapping("")
    public List<UserDTO> getAll(){
        List<User> users = userService.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();

        for (User user: users) {
            usersDTO.add(new UserDTO(user));
        }
        return usersDTO;
    }

    @CrossOrigin
    @GetMapping("roles")
    public List<RoleDTO> getAllRoles(){
        List<Role> roles = roleService.getAll();
        List<RoleDTO> rolesDTO = new ArrayList<>();

        for (Role role: roles) {
            rolesDTO.add(new RoleDTO(role));
        }
        return rolesDTO;
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody UserDTO userDTO, @PathVariable Long id){
        try{
            Optional<User> existUser = userService.getById(id);

            if(!existUser.isPresent()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            userDTO.setId(id);
            User user = new User(userDTO);
            userService.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
            } catch (NoSuchElementException e){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
