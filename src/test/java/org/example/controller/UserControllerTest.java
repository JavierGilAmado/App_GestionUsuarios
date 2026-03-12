package org.example.controller;

import org.example.repository.UserRepository;
import org.example.view.View;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserControllerTest {

    @Test
    void showUsers_deberiaPedirUsuariosAlRepositorio() {

        View view = mock(View.class);
        UserRepository repo = mock(UserRepository.class);

        UserController controller = new UserController(view, repo);

        controller.showUsers();

        verify(repo).showUser();
    }
}