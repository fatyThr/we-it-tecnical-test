package com.technical.test.weitproject.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class TimeSlotResponse extends RepresentationModel<DeliverySlotResponse> {


    private Long id;
    private LocalTime startDate;
    private LocalTime endDate;
    private boolean available;


}
