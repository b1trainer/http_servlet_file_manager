package org.example.project.model;

import java.util.List;

public class User {
    private long userId;
    private String firstName;
    private String lastName;
    private List<File> files;
    private List<Event> events;

    public User() {
    }

    public User(long userId, String firstName, String lastName, List<File> files, List<Event> events) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.files = files;
        this.events = events;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
