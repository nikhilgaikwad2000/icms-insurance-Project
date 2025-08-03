package com.icms.insurance.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClaimResponce {
    private Long claimId;
    private String policyName;
    private String reason;
    private String status;
    private LocalDateTime createdAt;
}
