package com.technical.test.weitproject.domain.Repositories;

import com.technical.test.weitproject.domain.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
    List<TimeSlot> findAllByAvailable(boolean available);
}
