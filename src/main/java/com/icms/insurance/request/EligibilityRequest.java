package com.icms.insurance.request;

import lombok.Data;

@Data
public class EligibilityRequest {

    private Long userID;
    private Long policyID;

}
