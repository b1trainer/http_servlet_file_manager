package org.example.project.dao;

import jakarta.persistence.*;
import org.example.project.ApplicationEvents;

@Entity
public class EventEntity {
    @Id
    private long id;
    private ApplicationEvents event;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ApplicationEvents getEvent() {
        return event;
    }

    public void setEvent(ApplicationEvents event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
