package com.musicplanet.controller.User;

import com.musicplanet.entities.Authentication.UserRegistrationRequest;
import com.musicplanet.services.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
@AllArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService registrationService;

    @CrossOrigin
    @PostMapping
    public String register(@RequestBody UserRegistrationRequest request) {
        return registrationService.register(request);
    }

    @CrossOrigin
    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }
}
