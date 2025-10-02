package org.example.project.service;

import org.example.project.model.User;

import java.util.List;

public interface UserService {
    void createUser(String firstName, String lastName);

    void deleteUser(long id);

    List<User> getUsers();

    User getUserById(long id);
}
