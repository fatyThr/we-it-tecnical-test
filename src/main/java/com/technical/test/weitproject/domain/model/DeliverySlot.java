package com.technical.test.weitproject.domain.model;

import com.technical.test.weitproject.infrastructure.config.DeliveryMode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DeliverySlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientName;

    private String clientPhone;

    @Enumerated(EnumType.STRING)
    private DeliveryMode deliveryMode;

    @ManyToOne
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;

    private boolean available;

}
