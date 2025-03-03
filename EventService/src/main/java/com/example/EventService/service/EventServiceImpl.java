package com.example.EventService.service;

import com.example.EventService.entity.Event;
import com.example.EventService.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getEventsByCategory(String category) {
        return eventRepository.findByCategory(category);
    }

    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setCategory(updatedEvent.getCategory());
            event.setEventDate(updatedEvent.getEventDate());
            event.setTags(updatedEvent.getTags());
            return eventRepository.save(event);
        }).orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }

    @Override
    public void deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            throw new RuntimeException("Event not found with id: " + id);
        }
        eventRepository.deleteById(id);
    }

    @Override
    public List<Event> getUpcomingEvents() {
        LocalDateTime now = LocalDateTime.now();
        return eventRepository.findAll().stream()
                .filter(event -> event.getEventDate() != null && event.getEventDate().isAfter(now))
                .collect(Collectors.toList());
    }

    @Override
    public List<Event> getEventsByTags(List<String> tags) {
        return eventRepository.findAll().stream()
                .filter(event -> event.getTags() != null && event.getTags().stream().anyMatch(tags::contains))
                .collect(Collectors.toList());
    }
}
