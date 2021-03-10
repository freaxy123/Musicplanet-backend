package MusicPlanet.Controller;

import  MusicPlanet.Repository.FakeDataStore;
import MusicPlanet.Model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {

    // this has to be static because web services are stateless
    private static final FakeDataStore fakeDataStore = new FakeDataStore();


    @GetMapping("/hello")
    @ResponseBody
    public String SayHello()
    {
        String msg = "Hello, your resources work!";
        return msg;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(value = "role") Optional<String> role) {

        List<User> users = null;

        if(role.isPresent()) {
            User.Role role_enum = null;
            System.out.println(role.get());

            if(role.get().equals("Administrator")){
                role_enum = User.Role.Administrator;
            }
            else if(role.get().equals("DJ")){
                role_enum = User.Role.Dj;
            }
            else if(role.get().equals("Moderator")){
                role_enum = User.Role.Moderator;
            }
            else{
                role_enum = User.Role.None;
            }
            users = fakeDataStore.getUsers(role_enum);
        }
        else {
            users = fakeDataStore.getUsers();
        }


        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("{id}") //GET at http://localhost:XXXX/student/3
    public ResponseEntity<User> getUserPath(@PathVariable(value = "id") int id) {
        User user = fakeDataStore.getUser(id);

        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
