package com.technical.test.weitproject.application.response;

import com.technical.test.weitproject.infrastructure.config.DeliveryMode;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalTime;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliverySlotResponse extends RepresentationModel<DeliverySlotResponse> {

    private Long id;

    private String clientName;

    private String clientPhone;

    @Enumerated(EnumType.STRING)
    private DeliveryMode deliveryMode;

    private LocalTime startDate;
    private LocalTime endDate;

    private boolean available;
}
