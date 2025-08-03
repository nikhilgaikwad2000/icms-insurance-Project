package com.icms.insurance.response;

import lombok.Data;

import java.time.LocalDate;

@Data

public class PolicyResponse {
    private long policyId;

    private  String policyName;
    private  String policyType;
    private String description;

    private Double coverageAmount;
    private Double premium;

    private String status;
    private LocalDate createdDate;
}
