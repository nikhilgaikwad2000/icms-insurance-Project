package com.icms.insurance.request;

import lombok.Data;

@Data
public class ClaimRequest {
    private Long policyId;
    private String reason;

}

