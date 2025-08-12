package app.persistence;

import app.entities.User;
import app.exception.CustomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    private static ConnectionPool connectionPool;

    public static void setConnectionPool(ConnectionPool newConnectionPool){
        connectionPool = newConnectionPool;
    }


    public static int addUser(String username, String password) throws CustomException{
        User user = new User(username, password);

        String sql = "INSERT INTO users (username,password) VALUES (?,?)";

        try (
                Connection connection = connectionPool.getConnection(); // Henter forbindelse til db
                PreparedStatement ps = connection.prepareStatement(sql) //sikkerhed under indsættelse i db
                ) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected;


        } catch (SQLException e) {
            String msg = "Fejl under oprettelse af konto (metode addUser)";
            throw new CustomException(msg, e.getMessage());
        }
    }

    public static User logIn(String username) throws CustomException{
        String sql = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                int id = rs.getInt("user_id");
                String password = rs.getString("password");

                User user = new User(id, username, password);
                return user;
            } else {
                return null;
            }
        } catch (SQLException e){
            throw new CustomException("Fejl ved login: ",e.getMessage());
        }

    }

    public static boolean userExist(User user) throws CustomException {
        String sql = "SELECT 1 FROM users WHERE username = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new CustomException("Brugernavn findes allerede: ", e.getMessage());

        }
    }
}
