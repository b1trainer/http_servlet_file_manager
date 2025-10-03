package org.example.project.service.impl;

import org.example.project.model.User;
import org.example.project.repository.UserRepository;
import org.example.project.repository.impl.UserRepositoryImpl;
import org.example.project.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepositoryImpl();
    }

    @Override
    public void createUser(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepository.createUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.getAllUsers();

        return users;
    }

    @Override
    public User getUserById(long id) {
        User user = userRepository.getUserById(id);

        return user;
    }
}
