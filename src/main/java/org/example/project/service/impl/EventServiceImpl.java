package org.example.project.service.impl;

import org.example.project.ApplicationEvents;
import org.example.project.model.Event;
import org.example.project.repository.EventRepository;
import org.example.project.repository.impl.EventRepositoryImpl;
import org.example.project.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

    public EventServiceImpl() {
        this.eventRepository = new EventRepositoryImpl();
    }

    @Override
    public void createEvent(ApplicationEvents event, String eventName) {
        Event newEvent = new Event();
        newEvent.setEvent(event);
        newEvent.setEventName(eventName);

        eventRepository.creteEvent(newEvent);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteEventById(eventId);
    }
}
