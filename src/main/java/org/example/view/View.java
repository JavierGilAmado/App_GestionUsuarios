package org.example.view;

import org.example.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final Scanner sc = new Scanner(System.in);

    public int getOption(){
        int option;
        option=Integer.parseInt(sc.nextLine());
        return option;
    }

    public int askForId() {
        System.out.print("Introduce el ID: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String askForName() {
        System.out.print("Introduce el NOMBRE: ");
        return sc.nextLine();
    }

    public String askForSurname() {
        System.out.print("Introduce el APELLIDO: ");
        return sc.nextLine();
    }

    public int askForAge() {
        System.out.print("Introduce la EDAD: ");
        return Integer.parseInt(sc.nextLine());
    }

        public void displayUsers (ArrayList<User> users){
        System.out.println("\n\nOPC 1: Usuarios existentes:\n");
        if (users.isEmpty()) System.out.println("No hay usuarios registrados");
        else{
            for(User u : users){
                System.out.println(u.toString());
            }
            System.out.println("\n\n");
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void byeMessage (){
        System.out.println("Cerrando aplicacion");
    }

    public void welcomeMessage (){
        System.out.println("Bienvenido a la aplicación de gestión de usuarios");
    }

    public void defaultMessage(){
        System.out.println("Opcion no valida");
    }

    public void menu(){
        System.out.println(" - - - MENU - - -");
        System.out.println("1. Ver todos los usuarios");
        System.out.println("2. Añadir usuario");
        System.out.println("3. Salir");
        System.out.print("\nIntroduce el numero de la opcion: ");
    }
}