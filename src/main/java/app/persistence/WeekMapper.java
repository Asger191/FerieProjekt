package app.persistence;

import app.entities.Day;
import app.entities.Week;
import app.exceptions.DatabaseException;

import java.sql.*;

public class WeekMapper {
private static ConnectionPool connectionPool;

    public static void setConnectionPool(ConnectionPool connectionPool) {
        WeekMapper.connectionPool = connectionPool;
    }

    public static int addWeek(int weekNumber) throws DatabaseException{
        String sql = "INSERT INTO week (week_number) VALUES(?) RETURNING week_id";

        try(Connection connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, weekNumber);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    return rs.getInt("week_id");
                } else {
                    throw new DatabaseException("Kunne ikke hente week_id");
                }
            }


        } catch (SQLException e){
            throw new DatabaseException(e.getMessage(), "Fejl med at indsætte uge nummer");
        }
    }


    public void addWeekInfo(Day day, int weekId) throws DatabaseException {
        String sql = "INSERT INTO day (breakfast, lunch, dinner, week_id) VALUES (?,?,?,?)";

        try(Connection connection = connectionPool.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1, day.getBreakfast());
            ps.setString(2, day.getLunch());
            ps.setString(3, day.getDinner());
            ps.setInt(4, weekId);

            ps.executeUpdate();

        } catch (SQLException e){
            throw new DatabaseException("Fejl med at indsætte weekend info", e.getMessage());
        }
    }

    public void addWeekWithDays(Week week) throws DatabaseException {
        int weekId = addWeek(week.getWeekNumber()); // Opret uge, få week_id
        for (Day d : week.getWeek()) {
            addWeekInfo(d, weekId); // Tilføj hver dag
        }
    }


    public void editWeekPlan(){
        String sql = "UPDATE day ";
    }

}
