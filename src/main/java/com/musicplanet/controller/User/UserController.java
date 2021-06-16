package com.musicplanet.controller.User;

import com.musicplanet.dto.UserDTO;
import com.musicplanet.entities.Artist;
import com.musicplanet.entities.Song;
import com.musicplanet.entities.User.User;
import com.musicplanet.services.ArtistService;
import com.musicplanet.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @GetMapping("")
    public List<UserDTO> getAll(){
        List<User> users = userService.getAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        System.out.println(users.size());

        for (User user: users) {
            usersDTO.add(new UserDTO(user));
        }


        return usersDTO;
    }
}
