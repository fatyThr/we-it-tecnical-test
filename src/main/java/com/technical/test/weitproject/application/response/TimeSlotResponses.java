package com.technical.test.weitproject.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class TimeSlotResponses extends RepresentationModel<DeliverySlotResponse> {


    private List<TimeSlotResponse> timeSlotAvalaibleResponses = new ArrayList<>();


}
