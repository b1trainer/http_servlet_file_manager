package org.example.project.model;

import org.example.project.ApplicationEvents;

public class Event {
    private long eventId;
    private ApplicationEvents event;
    private String eventName;

    public Event() {
    }

    public Event(long eventId, ApplicationEvents event, String eventName) {
        this.eventId = eventId;
        this.event = event;
        this.eventName = eventName;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public ApplicationEvents getEvent() {
        return event;
    }

    public void setEvent(ApplicationEvents event) {
        this.event = event;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event=" + event +
                ", eventName='" + eventName + '\'' +
                '}';
    }
}
