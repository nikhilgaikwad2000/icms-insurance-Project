package com.icms.insurance.controller;

import com.icms.insurance.response.PolicyResponse;
import com.icms.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies/view")
public class PolicyViewController {

    @Autowired
    private PolicyService policyService;

    // View all available policies
    @GetMapping("/all")
    public ResponseEntity<List<PolicyResponse>> getAllPolicies() {
        List<PolicyResponse> allPolicies = policyService.getAllPolicies();
        return ResponseEntity.ok(allPolicies);
    }

    // View a specific policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponse> getPolicyById(@PathVariable Long id) {
        PolicyResponse policy = policyService.getPolicyById(id);
        return ResponseEntity.ok(policy);
    }
}
