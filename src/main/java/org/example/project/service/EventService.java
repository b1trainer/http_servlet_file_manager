package org.example.project.service;

import org.example.project.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getEvents();

    void createEvent(String event, String fileName);

    void deleteEvent(long eventId);
}
