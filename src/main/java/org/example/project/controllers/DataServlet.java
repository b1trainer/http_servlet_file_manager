package org.example.project.controllers;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.project.ApplicationEvents;
import org.example.project.model.User;
import org.example.project.service.EventService;
import org.example.project.service.FileService;
import org.example.project.service.UserService;
import org.example.project.service.impl.EventServiceImpl;
import org.example.project.service.impl.FileServiceImpl;
import org.example.project.service.impl.UserServiceImpl;
import org.example.project.utils.DataMapper;

import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "dataServlet", value = "/data")
@MultipartConfig
public class DataServlet extends HttpServlet {
    private FileService fileService;
    private UserService userService;
    private EventService eventService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        fileService = new FileServiceImpl();
        userService = new UserServiceImpl();
        eventService = new EventServiceImpl();
    }

    /**
     * Получение конкретного пользователя с привязанными к нему файлами и историей событий
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");

        try {
            long id = Long.parseLong(userId);

            User user = userService.getUserById(id);

            response.setContentType("application/json");
            response.getWriter().write(DataMapper.getInstance().writeValueAsString(user));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID");
        }
    }

    /**
     * Загрузка файла пользователем
     * Регистрация события загрузки файла пользователем
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        fileService.uploadFile(filePart, fileName);
        eventService.createEvent(ApplicationEvents.FILE_UPLOAD, fileName);
    }

    /**
     * Удаление файла пользователем
     * Удаление события пользователем
     * Регистрация события удаления
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String eventId = req.getParameter("eventId");

        if (eventId != null) {
            deleteEvent(eventId, req, resp);
        }

        String fileId = req.getParameter("fileId");

        if (fileId != null) {
            deleteFile(fileId, req, resp);

            eventService.createEvent(ApplicationEvents.FILE_DELETE, fileId);
        }
    }

    private void deleteEvent(String eventId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            long id = Long.parseLong(eventId);
            eventService.deleteEvent(id);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event ID");
        }
    }

    private void deleteFile(String fileId, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            long id = Long.parseLong(fileId);
            fileService.deleteFile(id);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid file ID");
        }
    }

}
