package com.technical.test.weitproject.application.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Client Api",
        description = "Rest API for CRUD operation")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    @GetMapping("/hello")
    public ResponseEntity<String> getDeliverySlot() {
        return ResponseEntity.ok("Hello world ! ");
    }
}
