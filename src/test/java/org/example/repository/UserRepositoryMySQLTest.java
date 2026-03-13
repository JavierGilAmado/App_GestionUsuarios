package org.example.repository;

import org.example.database.DatabaseConnection;
import org.example.model.User;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryMySQLTest {

    private UserRepositoryMySQL repository;

    @BeforeEach
    void setUp() {   //Limpia la db
        repository = new UserRepositoryMySQL();
        clearDatabase();
    }

    void clearDatabase() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("DELETE FROM users");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldAddUserAndReturnItInShowUsers() {

        User user = new User(1, "Juan", "Perez", 30);

        repository.addUser(user);

        ArrayList<User> users = repository.showUser();

        assertEquals(1, users.size());
        assertEquals("Juan", users.get(0).getName());
        assertEquals("Perez", users.get(0).getSurname());
        assertEquals(30, users.get(0).getAge());
    }

    @Test
    void shouldDeleteUser() {

        User user = new User(1, "Ana", "Lopez", 25);

        repository.addUser(user);

        repository.deleteUser(1);

        ArrayList<User> users = repository.showUser();

        assertTrue(users.isEmpty());
    }
}