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
    public void modifyUser(User user) {
        for (int i = 0; i < usersData.size(); i++) {
            if (usersData.get(i).getId() == user.getId()) {
                usersData.set(i, user);
                return;
            }
        }
    }

    @Override
    public void deleteUser(int id) {
        usersData.removeIf(user -> user.getId() == id);
    }
}
