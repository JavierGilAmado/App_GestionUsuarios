package org.example.repository;

import org.example.model.User;

import java.util.ArrayList;

public interface UserRepository {

    public ArrayList<User> showUser();

    public void addUser(User newUser);

    public void modifyUser();

    public void deleteUser();
}
