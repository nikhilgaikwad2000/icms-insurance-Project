package com.icms.insurance.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Builder
public class Eligibility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eligibilityId;

    @ManyToOne

    private User user;

    @ManyToOne

    private Policy policy;

    private boolean eligible;

    private LocalDate decisionDate;

    private String reason;
}
