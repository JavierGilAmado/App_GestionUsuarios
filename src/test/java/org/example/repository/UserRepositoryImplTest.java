package org.example.repository;

import org.example.model.User;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    @Test
    void addUser_deberiaGuardarUsuario() {

        // Arrange
        UserRepositoryImpl repo = new UserRepositoryImpl();
        User user = new User(1,"Juan","Perez",25);

        // Act
        repo.addUser(user);
        ArrayList<User> users = repo.showUser();

        // Assert
        assertEquals(1, users.size());
        assertEquals("Juan", users.get(0).getName());
    }

    @Test
    void showUser_deberiaEstarVaciaAlInicio() {

        UserRepositoryImpl repo = new UserRepositoryImpl();

        ArrayList<User> users = repo.showUser();

        assertTrue(users.isEmpty());
    }

}