package MusicPlanet.Repository;

import MusicPlanet.Model.User;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {
    private int auto_increment = 0;

    private final List<User> userList = new ArrayList<>();

    private int getAuto_increment(){
        return auto_increment++;
    }

    public void setAuto_increment(int auto_increment) {
        this.auto_increment = auto_increment;
    }

    public FakeDataStore() {
        userList.add(new User( 1, User.Role.None, "james@gmail.com", "jamess", "hello123"));
        userList.add(new User(2, User.Role.Moderator, "loren@gmail.com", "loren123", "mynameisloren"));
        userList.add(new User(3, User.Role.Administrator, "michael@gmail.com", "micheal5612", "michaelspass"));

    }

    public List<User> getUsers() {
        return userList;
    }

    public List<User> getUsers(User.Role role) {
        List<User> filtered = new ArrayList<>();
        for (User user : userList) {
            if (user.getRole().equals(role)) {
                filtered.add(user);
            }
        }
        return filtered;
    }

    public User getUser(int id) {
        for (User user : userList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }
}
