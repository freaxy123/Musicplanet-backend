package com.musicplanet.services.User;

import com.musicplanet.entities.Artist;
import com.musicplanet.entities.Authentication.ConfirmationToken;
import com.musicplanet.entities.Song;
import com.musicplanet.entities.User.Role;
import com.musicplanet.repository.User.UserRepository;

import com.musicplanet.services.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.musicplanet.entities.User.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userRepository.getByUsername(username).isEmpty()){
            return userRepository.getByEmail(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException(
                                    String.format(USER_NOT_FOUND_MSG, username)));
        }
        else{
            return userRepository.getByUsername(username)
                    .orElseThrow(() ->
                            new UsernameNotFoundException(
                                    String.format(USER_NOT_FOUND_MSG, username)));
        }
    }

    public String register(User user) {
        boolean userExists = userRepository.getByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    public int enableUser(String email) {
        return userRepository.enable(email);
    }

    public void giveUserRole(long id, Role role){
       User user = userRepository.getById(id).get();
       user.getRoles().add(role);
       userRepository.save(user);
    }

    public List<User> getAll(){return userRepository.getAll();}

    public Optional<User> getById(Long id){return userRepository.getById(id);}

    public void save(User user){userRepository.save(user);}
}
