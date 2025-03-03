package com.example.EventService.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_event_registration")
public class UserEventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public UserEventRegistration() {}

    public UserEventRegistration(Long userId, Event event) {
        this.userId = userId;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
