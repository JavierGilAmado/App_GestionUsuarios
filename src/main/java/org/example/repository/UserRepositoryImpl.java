package org.example.repository;

import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private List<User> usersData = new ArrayList<>();

    @Override
    public ArrayList<User> showUser() {
        return new ArrayList<>(usersData);
    }

    @Override
    public void addUser(User newUser) {
        usersData.add(newUser);
    }

    @Override
    public void modifyUser() {
        //Implement
    }

    @Override
    public void deleteUser() {
        //Implement
    }
}
