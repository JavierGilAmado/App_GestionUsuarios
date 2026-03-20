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

            // Esto asegura que el test no explote si por alguna razón la tabla no está
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(100), surname VARCHAR(100), age INT)");
            stmt.executeUpdate("DELETE FROM users");

        } catch (SQLException e) {
            e.printStackTrace();
            fail("Error al limpiar la base de datos: " + e.getMessage()); // Esto hará que el test falle con el error real
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