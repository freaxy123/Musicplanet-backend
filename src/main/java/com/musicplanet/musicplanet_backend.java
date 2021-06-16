package com.musicplanet;

import com.musicplanet.entities.User.Role;
import com.musicplanet.entities.User.User;
import com.musicplanet.repository.Role.RoleRepository;
import com.musicplanet.repository.User.UserRepository;
import com.musicplanet.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class musicplanet_backend {
    public static void main(String[] args) {
        SpringApplication.run(musicplanet_backend.class, args);
    }

    @Bean
    public CommandLineRunner ApplicationData(UserService userService, RoleRepository roleRepository, UserRepository userRepository) {
        return args -> {
            roleRepository.save(new Role(1L,"USER"));
            roleRepository.save(new Role(2L, "ADMIN"));

            System.out.println(roleRepository.findById(2l).getName());

            //Admin
            userService.register(
                    new User(
                            "admin",
                            "Admin@Admin",
                            "root"
                            ,roleRepository.findByName("USER")
                    ));
            userService.enableUser("Admin@Admin");
            userService.giveUserRole(1L, roleRepository.findByName("ADMIN"));

            //User
            userService.register(
                    new User(
                            "freek",
                            "freek.vlier@gmail.com",
                            "password"
                            ,roleRepository.findByName("USER")
                    ));
            userService.enableUser("freek.vlier@gmail.com");
        };

    }
}
