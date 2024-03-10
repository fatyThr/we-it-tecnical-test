package com.technical.test.weitproject.application.controller;

import com.technical.test.weitproject.application.request.DeliverySlotRequest;
import com.technical.test.weitproject.application.response.DeliverySlotResponse;
import com.technical.test.weitproject.application.response.DeliverySlotResponses;
import com.technical.test.weitproject.application.response.TimeSlotResponses;
import com.technical.test.weitproject.domain.service.DeliveryService;
import com.technical.test.weitproject.infrastructure.config.DeliveryMode;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Tag(name = "Client Api",
        description = "Rest API for CRUD operation")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;
    @GetMapping("/slots/{id}")
    public ResponseEntity<DeliverySlotResponse>  getDeliverySlotById( @PathVariable("id") Long id) {
        DeliverySlotResponse deliverySlotResponse=deliveryService.getDeliverySlotById(id);
        addLinkToDeliverySlot(deliverySlotResponse);
        return new ResponseEntity<>(deliverySlotResponse, HttpStatus.OK);
     }

    @GetMapping("/times-slot")
    public ResponseEntity<TimeSlotResponses>  getAllTimesSlots() {
        TimeSlotResponses timeSlotResponses=new TimeSlotResponses();
        timeSlotResponses.setTimeSlotAvalaibleResponses(deliveryService.getAllTimesSlots());
        Link selfLink = linkTo(methodOn(DeliveryController.class).getAllDeliverySlots()).withSelfRel();
        timeSlotResponses.add(selfLink);
        return ResponseEntity.ok(timeSlotResponses);
    }
    @GetMapping("/slots")
    public ResponseEntity<DeliverySlotResponses>  getAllDeliverySlots() {
        DeliverySlotResponses deliverySlotResponses=new DeliverySlotResponses();
        deliverySlotResponses.setDeliverySlotResponses(deliveryService.getAllDeliverySlots());
        Link selfLink = linkTo(methodOn(DeliveryController.class).getAllTimesSlots()).withSelfRel();
        deliverySlotResponses.add(selfLink);
        return ResponseEntity.ok(deliverySlotResponses);
    }
    @PatchMapping("/choose-mode")
    public ResponseEntity<Void> chooseDeliveryMode(@RequestParam Long deliveryId, @RequestParam String deliveryMode) {
        deliveryService.chooseDeliveryMode(deliveryId, DeliveryMode.valueOf(deliveryMode));
        return ResponseEntity.noContent().build();

    }
    @PostMapping("/slots")
    public ResponseEntity<DeliverySlotResponse> saveDeliverySlot(@RequestBody DeliverySlotRequest deliverySlotRequest) {
        DeliverySlotResponse deliverySlotResponse=deliveryService.saveDeliverySlot(deliverySlotRequest);
        return new ResponseEntity<>(deliverySlotResponse, HttpStatus.CREATED);

    }
    private void addLinkToDeliverySlot(DeliverySlotResponse deliverySlot) {
        Link link = linkTo(DeliveryController.class).slash(deliverySlot.getId()).withSelfRel();
        deliverySlot.add(link);
        ResponseEntity<DeliverySlotResponse> methodLinkBuilder =
                methodOn(DeliveryController.class).getDeliverySlotById(deliverySlot.getId());
        Link reportLink = linkTo(methodLinkBuilder).withRel("slots");
        deliverySlot.add(reportLink);
    }
}
