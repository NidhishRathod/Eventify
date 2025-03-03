package com.example.EventService.repository;

import com.example.EventService.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByCategory(String category);

    List<Event> findByEventDateAfter(LocalDateTime now);

    @Query("SELECT e FROM Event e JOIN e.tags t WHERE t IN :tags")
    List<Event> findByTags(@Param("tags") List<String> tags);
}
