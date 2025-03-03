package com.example.EventService.service;

import com.example.EventService.entity.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {

    Event createEvent(Event event);

    Optional<Event> getEventById(Long id);

    List<Event> getAllEvents();

    List<Event> getEventsByCategory(String category);

    Event updateEvent(Long id, Event updatedEvent);

    void deleteEvent(Long id);

    List<Event> getUpcomingEvents();

    List<Event> getEventsByTags(List<String> tags);
}
