package com.example.EventService.controller;

import com.example.EventService.entity.Event;
import com.example.EventService.service.AIRecommendationService;
import com.example.EventService.service.EventService;
import com.example.EventService.service.EventWebSocketHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final AIRecommendationService aiRecommendationService;
    private final EventWebSocketHandler eventWebSocketHandler;

    public EventController(EventService eventService,
                           AIRecommendationService aiRecommendationService,
                           EventWebSocketHandler eventWebSocketHandler) {
        this.eventService = eventService;
        this.aiRecommendationService = aiRecommendationService;
        this.eventWebSocketHandler = eventWebSocketHandler;
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event savedEvent = eventService.createEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Event>> getEventsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(eventService.getEventsByCategory(category));
    }

    /**
     * Recommends events based on user interest tags.
     */
    @GetMapping("/recommend")
    public ResponseEntity<List<String>> recommendEvent(@RequestParam String userInterests) {

        // Convert comma-separated interests into a list, trimming spaces
        List<String> interestList = Arrays.stream(userInterests.split(","))
                .map(String::trim)
                .toList();

        // Get recommended event titles
        List<String> recommendations = aiRecommendationService.recommendEvent(interestList);
        return ResponseEntity.ok(recommendations);
    }

    @PostMapping("/live-update")
    public ResponseEntity<String> sendLiveUpdate(@RequestBody String message) {
        eventWebSocketHandler.sendLiveEventUpdate(message);
        return ResponseEntity.ok("Live event update sent!");
    }
}
