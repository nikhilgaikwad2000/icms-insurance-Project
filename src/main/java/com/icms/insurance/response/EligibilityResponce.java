package com.icms.insurance.response;

import lombok.Data;

@Data
public class EligibilityResponce {
    private  Long userID;
    private  Long policyID;
    private String policyType;
    private boolean isEligible;
    private String message;
}
