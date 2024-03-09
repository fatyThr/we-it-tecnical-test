package com.technical.test.weitproject.domain.service.mapper;

import com.technical.test.weitproject.application.response.DeliverySlotResponse;
import com.technical.test.weitproject.domain.model.DeliverySlot;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliverySlotMapper {
    DeliverySlotResponse deliverySlotToDeliverySlotResponse(DeliverySlot deliverySlot);
}
