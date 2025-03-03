package com.example.EventService.repository;

import com.example.EventService.entity.UserEventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRegistrationRepository extends JpaRepository<UserEventRegistration, Long> {
    boolean existsByUserIdAndEventId(Long userId, Long eventId);
}
