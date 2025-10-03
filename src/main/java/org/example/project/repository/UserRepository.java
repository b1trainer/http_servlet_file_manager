package org.example.project.repository;

import org.example.project.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(long id);

    void createUser(User user);

    void deleteUser(long id);
}
