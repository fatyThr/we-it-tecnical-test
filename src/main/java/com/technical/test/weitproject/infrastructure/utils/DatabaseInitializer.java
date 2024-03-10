package com.technical.test.weitproject.infrastructure.utils;

import com.technical.test.weitproject.domain.Repositories.DeliverySlotRepository;
import com.technical.test.weitproject.domain.Repositories.TimeSlotRepository;
import com.technical.test.weitproject.domain.model.DeliverySlot;
import com.technical.test.weitproject.domain.model.TimeSlot;
import com.technical.test.weitproject.infrastructure.config.DeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final TimeSlotRepository timeSlotRepository;
    private final DeliverySlotRepository deliverySlotRepository;

    @Autowired
    public DatabaseInitializer(TimeSlotRepository timeSlotRepository, DeliverySlotRepository deliverySlotRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.deliverySlotRepository = deliverySlotRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LocalDate day = LocalDate.now();
        LocalTime now = LocalTime.now();
        TimeSlot timeSlot1=new TimeSlot(1L, day,now,now.plusHours(1));
        TimeSlot timeSlot2=new TimeSlot(2L, day.plusDays(1),now.minusHours(1),now);
        TimeSlot timeSlot3=new TimeSlot(3L, day,now.plusHours(2),now.plusHours(3));
        timeSlotRepository.save(timeSlot1);
        timeSlotRepository.save(timeSlot2);
        timeSlotRepository.save(timeSlot3);

        deliverySlotRepository.save(DeliverySlot.builder().timeSlot(timeSlot1).available(true).clientName("John Doe").clientPhone("123-456-7890").deliveryMode(DeliveryMode.DELIVERY).build());
        deliverySlotRepository.save(DeliverySlot.builder().timeSlot(timeSlot2).available(false).clientName("Albert Doe").clientPhone("123-456-7890").deliveryMode(DeliveryMode.DRIVE).build());
        deliverySlotRepository.save(DeliverySlot.builder().timeSlot(timeSlot3).available(true).clientName("Elsa Albert").clientPhone("123-456-7890").deliveryMode(DeliveryMode.DELIVERY_TODAY).build());

    }
}

