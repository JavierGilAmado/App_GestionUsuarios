package org.example;

import org.example.controller.UserController;
import org.example.repository.UserRepository;
import org.example.repository.UserRepositoryImpl;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        UserRepository repo = new UserRepositoryImpl(); //Aquí pasamos la implementación
        View vista = new View();

        UserController controller = new UserController(vista, repo);
        controller.runApp();
    }
}