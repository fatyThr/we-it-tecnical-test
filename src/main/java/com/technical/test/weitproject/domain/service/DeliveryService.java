package com.technical.test.weitproject.domain.service;

import com.technical.test.weitproject.application.request.DeliverySlotRequest;
import com.technical.test.weitproject.application.response.DeliverySlotResponse;
import com.technical.test.weitproject.application.response.TimeSlotResponse;

import java.util.List;


public interface DeliveryService {

    DeliverySlotResponse getDeliverySlotById(Long id);
    List<DeliverySlotResponse> getAllDeliverySlots();
    DeliverySlotResponse saveDeliverySlot(DeliverySlotRequest deliverySlotRequest);
    void chooseDeliveryMode(Long deliveryId, DeliverySlotRequest deliverySlotRequest);

    List<TimeSlotResponse> getAllAvailableTimesSlots();
}
