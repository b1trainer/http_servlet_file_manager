package org.example.project.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project.ApplicationEvents;
import org.example.project.model.User;
import org.example.project.service.EventService;
import org.example.project.service.UserService;
import org.example.project.service.impl.EventServiceImpl;
import org.example.project.service.impl.UserServiceImpl;
import org.example.project.utils.DataMapper;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "usersServlet", value = "/users")
public class UsersServlet extends HttpServlet {

    private UserService userService;
    private EventService eventService;

    @Override
    public void init(ServletConfig config) {
        userService = new UserServiceImpl();
        eventService = new EventServiceImpl();
    }

    /**
     * Получение списка пользователей, либо перенаправление на конкретного пользователя
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("id");

        if (userId == null) {
            getAllUsers(request, response);
        } else {
            getUserById(userId, request, response);
        }
    }

    /**
     * Создание пользователя
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (firstName != null && lastName != null) {
            userService.createUser(firstName, lastName);

            eventService.createEvent(ApplicationEvents.USER_CREATE, firstName + " " + lastName);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user initials");
        }
    }

    /**
     * Удаление пользователя
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        try {
            long userId = Long.parseLong(id);
            userService.deleteUser(userId);

            eventService.createEvent(ApplicationEvents.USER_DELETE, id);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
        }
    }


    private void getAllUsers(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        List<User> users = userService.getUsers();

        response.setContentType("application/json");
        response.getWriter().write(DataMapper.getInstance().writeValueAsString(users));
    }

    private void getUserById(String id, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            long userId = Long.parseLong(id);

            response.sendRedirect(request.getContextPath() + "/data?userId=" + userId);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
        }
    }

}