package app.entities;

public class User {

    String username;
    String password;
    int userId;

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(int userId ,String username, String password){
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

}
