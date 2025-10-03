package org.example.project.repository;

import org.example.project.model.Event;

import java.util.List;

public interface EventRepository {
    void creteEvent(Event event);

    void deleteEventById(long id);

}
