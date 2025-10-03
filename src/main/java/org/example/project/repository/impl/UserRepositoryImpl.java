package org.example.project.repository.impl;

import org.example.project.model.User;
import org.example.project.repository.UserRepository;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(long id) {

    }
}
