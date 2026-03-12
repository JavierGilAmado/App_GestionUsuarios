package org.example.controller;

import org.example.model.User;
import org.example.repository.UserRepository;
import org.example.view.View;

public class UserController {
    private final View view;
    private final UserRepository userRepository; // Usamos la interfaz

    public UserController(View view, UserRepository repository) {
        this.view = view;
        this.userRepository = repository;
    }

    public void runApp(){
        view.showMessage("\nBienvenido a la aplicacion de gestion de usuarios.\n");
        boolean exit=false;
        int opc;
        while (!exit){
            view.menu();
            try{
                opc=view.getOption();
                switch (opc){
                    case 1:
                        showUsers();
                        break;

                    case 2:
                        addUser();
                        break;

                    case 3:
                        view.showMessage("\n\nCerrando aplicacion...\n");
                        exit=true;
                        break;

                    default:
                        view.showMessage("\n\nOpcion no valida\n\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nDebes introducir un numero\n\n");
            }
        }
    }

    public void showUsers (){
        view.displayUsers(userRepository.showUser());
    }

    public void addUser() {
        try {
            int id = view.askForId();
            String name = view.askForName();
            String surname = view.askForSurname();
            int age = view.askForAge();

            // El controlador crea la instancia (conoce al Modelo)
            User newUser = new User(id, name, surname, age);

            // El controlador le dice al repositorio que lo guarde
            userRepository.addUser(newUser);

            view.showMessage("\nUsuario añadido con exito.\n\n");
        } catch (NumberFormatException e) {
            view.showMessage("Error: Debes introducir un numero valido.\n\n");
        }
    }
}
