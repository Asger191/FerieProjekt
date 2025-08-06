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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
