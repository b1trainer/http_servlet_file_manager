package org.example.project.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project.model.User;
import org.example.project.service.UserService;
import org.example.project.service.impl.UserServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", value = "/users")
public class UsersServlet extends HttpServlet {

    private UserService userService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) {
        userService = new UserServiceImpl();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");

        if (userId == null) {
            getAllUsers(request, response);
        } else {
            getUserById(userId, request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (firstName != null && lastName != null) {
            userService.createUser(firstName, lastName);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user initials");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");


        try {
            long userId = Long.parseLong(id);
            userService.deleteUser(userId);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
        }
    }


    private void getAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<User> users = userService.getUsers();

        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(users));
    }

    private void getUserById(String id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            long userId = Long.parseLong(id);
            User user = userService.getUserById(userId);

            if (user != null) {
                response.setContentType("application/json");
                response.getWriter().write(objectMapper.writeValueAsString(user));
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
        }
    }

}