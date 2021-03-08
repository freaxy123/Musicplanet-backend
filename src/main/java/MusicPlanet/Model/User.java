package MusicPlanet.Model;

public class User {

    private int id;
    private String username; // full name, e.g., "Joe Smith"
    private String password; // country where the students comes from
    private String email;

    public User(int id, String email, String username, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(){

    }

    public int getId(){
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", email='" + email + '\'' +
                ", username=" + username +
                ", password=" + password +
                '}';
    }

}
