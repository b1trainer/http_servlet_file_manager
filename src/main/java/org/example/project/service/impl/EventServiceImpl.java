package org.example.project.service.impl;

import org.example.project.model.Event;
import org.example.project.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    @Override
    public List<Event> getEvents() {
        return List.of();
    }

    @Override
    public void createEvent(String event, String fileName) {

    }

    @Override
    public void deleteEvent(long eventId) {

    }
}
