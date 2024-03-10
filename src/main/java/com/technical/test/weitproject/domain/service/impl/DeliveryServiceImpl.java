package com.technical.test.weitproject.domain.service.impl;

import com.technical.test.weitproject.application.request.DeliverySlotRequest;
import com.technical.test.weitproject.application.response.DeliverySlotResponse;
import com.technical.test.weitproject.application.response.TimeSlotResponse;
import com.technical.test.weitproject.domain.Repositories.DeliverySlotRepository;
import com.technical.test.weitproject.domain.Repositories.TimeSlotRepository;
import com.technical.test.weitproject.domain.model.DeliverySlot;
import com.technical.test.weitproject.domain.model.TimeSlot;
import com.technical.test.weitproject.domain.service.DeliveryService;
import com.technical.test.weitproject.domain.service.mapper.DeliverySlotMapper;
import com.technical.test.weitproject.domain.service.mapper.TimeSlotMapper;
import com.technical.test.weitproject.infrastructure.config.DeliveryMode;
import com.technical.test.weitproject.infrastructure.exceptions.TechnicalException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Slf4j
@AllArgsConstructor
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliverySlotRepository deliverySlotRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final DeliverySlotMapper deliverySlotMapper;
    private final TimeSlotMapper timeSlotMapper;

    @Override
    public DeliverySlotResponse getDeliverySlotById(Long id) {
        return deliverySlotMapper.deliverySlotToDeliverySlotResponse(deliverySlotRepository.findById(id).orElseThrow(() -> new TechnicalException("error.delivery.slot.not.found", id))
        );
    }

    @Override
    public List<DeliverySlotResponse> getAllDeliverySlots() {
        return deliverySlotRepository.findAll().stream().map(deliverySlotMapper::deliverySlotToDeliverySlotResponse).toList();
    }


    @Override
    public DeliverySlotResponse saveDeliverySlot(DeliverySlotRequest deliverySlotRequest) {
        TimeSlot timeSlot = getTimeSlot(deliverySlotRequest);
        DeliverySlot deliverySlot = DeliverySlot.builder()
                .clientName(deliverySlotRequest.getClientName())
                .deliveryMode(deliverySlotRequest.getDeliveryMode())
                .clientPhone(deliverySlotRequest.getClientPhone())
                .timeSlot(timeSlot)
                .available(true)
                .build();

        return deliverySlotMapper.deliverySlotToDeliverySlotResponse(deliverySlotRepository.save(deliverySlot));
    }

    private TimeSlot getTimeSlot(DeliverySlotRequest deliverySlotRequest) {
        return timeSlotRepository.findById(deliverySlotRequest.getTimeSlotId()).orElseThrow(() -> new TechnicalException("error.time.slot.not.found", deliverySlotRequest.getTimeSlotId()));

    }

    @Override
    public void chooseDeliveryMode(Long deliveryId, DeliveryMode deliveryMode) {
        log.info("Service to update delivery slot {} payload : {}", deliveryId, deliveryMode);
        DeliverySlot deliverySlot = deliverySlotRepository.findById(deliveryId).orElseThrow(() -> new TechnicalException("error.delivery.slot.not.found", deliveryId));
        deliverySlot.setDeliveryMode(deliveryMode);
        deliverySlotRepository.save(deliverySlot);
    }

    @Override
    public List<TimeSlotResponse> getAllTimesSlots() {
        log.info("Service to get all available time slot ");
        return timeSlotRepository.findAll().stream().map(timeSlotMapper::timeSlotToTimeSlotResponse).toList();
    }
}
