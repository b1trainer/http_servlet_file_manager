package org.example.project.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.project.model.Event;
import org.example.project.service.EventService;
import org.example.project.service.impl.EventServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "eventsServlet", value = "/events")
public class EventsServlet extends HttpServlet {

    private EventService eventService;
    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) {
        eventService = new EventServiceImpl();
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Event> events = eventService.getEvents();

        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(events));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String event = request.getParameter("event");
        String filename = request.getParameter("filename");

        if (event != null && filename != null) {
            eventService.createEvent(event, filename);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event description");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        try {
            long eventId = Long.parseLong(id);
            eventService.deleteEvent(eventId);

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid event ID");
        }
    }
}
