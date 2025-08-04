package com.icms.insurance.service;

import com.icms.insurance.request.EligibilityRequest;
import com.icms.insurance.response.EligibilityResponce;

public interface EligibilityService {
 public EligibilityResponce checkEligibility(EligibilityRequest request);
}
