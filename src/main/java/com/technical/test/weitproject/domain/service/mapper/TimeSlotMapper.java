package com.technical.test.weitproject.domain.service.mapper;

import com.technical.test.weitproject.application.response.TimeSlotResponse;
import com.technical.test.weitproject.domain.model.TimeSlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlotResponse timeSlotToTimeSlotResponse(TimeSlot timeSlot);
}
