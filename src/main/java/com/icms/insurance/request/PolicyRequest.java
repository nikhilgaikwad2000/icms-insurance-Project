package com.icms.insurance.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PolicyRequest {

    private  String policyName;
    private  String policyType;
    private String description;

    private Double coverageAmount;
    private Double premium;

    private String status;
    private LocalDate createdDate;
}
