
package com.icms.insurance.controller;

import com.icms.insurance.request.EligibilityRequest;
import com.icms.insurance.response.EligibilityResponce;
import com.icms.insurance.service.EligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    @Autowired
    private EligibilityService eligibilityService;

    @PostMapping("/check")
    public ResponseEntity<EligibilityResponce> checkEligibility(@RequestBody EligibilityRequest request) {
        EligibilityResponce response = eligibilityService.checkEligibility(request);
        return ResponseEntity.ok(response);
    }
}
