package com.example.EventService.service;

import com.example.EventService.entity.Event;
import com.example.EventService.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AIRecommendationService {

    private final EventRepository eventRepository;

    public AIRecommendationService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<String> recommendEvent(List<String> userInterests) {
        if (userInterests.isEmpty()) {
            return List.of("No recommendations available.");
        }

        // Normalize input tags (convert to lowercase and trim spaces)
        Set<String> normalizedInterests = userInterests.stream()
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toSet());

        // Fetch events whose tags match user interests
        List<String> matchingEvents = eventRepository.findAll().stream()
                .filter(event -> hasMatchingTags(event, normalizedInterests))
                .map(Event::getTitle)
                .collect(Collectors.toList());

        return matchingEvents.isEmpty()
                ? List.of("No relevant recommendations found.")
                : matchingEvents;
    }

    /**
     * Checks if an event contains at least one tag from the user interests.
     */
    private boolean hasMatchingTags(Event event, Set<String> userInterests) {
        // Normalize event tags
        Set<String> eventTags = event.getTags().stream()
                .map(String::toLowerCase)
                .map(String::trim)
                .collect(Collectors.toSet());

        // Check for intersection between user interests and event tags
        return !eventTags.isEmpty() && eventTags.stream().anyMatch(userInterests::contains);
    }
}
