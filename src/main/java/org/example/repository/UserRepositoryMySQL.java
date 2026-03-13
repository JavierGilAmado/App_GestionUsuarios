package org.example.repository;

import org.example.database.DatabaseConnection;
import org.example.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserRepositoryMySQL implements UserRepository {

    @Override
    public ArrayList<User> showUser() {

        ArrayList<User> users = new ArrayList<>();

        String query = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getInt("age")
                );

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public void addUser(User newUser) {

        String query = "INSERT INTO users (id, name, surname, age) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, newUser.getId());
            stmt.setString(2, newUser.getName());
            stmt.setString(3, newUser.getSurname());
            stmt.setInt(4, newUser.getAge());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifyUser(User user) {
        String query = "UPDATE users SET name=?, surname=?, age=? WHERE id=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getSurname());
            stmt.setInt(3, user.getAge());
            stmt.setInt(4, user.getId());

            int rows = stmt.executeUpdate();

            if(rows == 0){
                System.out.println("No se encontró el usuario con ID: " + user.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();

            if(rows == 0){
                System.out.println("No se encontró el usuario con ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
