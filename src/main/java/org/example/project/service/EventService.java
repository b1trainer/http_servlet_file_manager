package org.example.project.service;

import org.example.project.ApplicationEvents;
import org.example.project.model.Event;

import java.util.List;

public interface EventService {

    void createEvent(ApplicationEvents event, String name);

    void deleteEvent(long eventId);
}
