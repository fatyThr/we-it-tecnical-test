package com.technical.test.weitproject.application.request;

import com.technical.test.weitproject.infrastructure.config.DeliveryMode;
import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class DeliverySlotRequest {

    private DeliveryMode deliveryMode;
    private Long timeSlotId;
    private String clientName;
    private String clientPhone;
    private LocalTime startDate;
    private LocalTime endDate;

}
