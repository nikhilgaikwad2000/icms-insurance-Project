package com.icms.insurance.request;

import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class ClaimRequest {
    @Null
    private Long policyId;
    private String reason;

}

