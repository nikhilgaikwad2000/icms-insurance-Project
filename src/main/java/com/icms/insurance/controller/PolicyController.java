package com.icms.insurance.controller;

import com.icms.insurance.request.PolicyRequest;
import com.icms.insurance.response.PolicyResponse;
import com.icms.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/save/policy")
    public ResponseEntity<String> createPolicy(@RequestBody PolicyRequest request) {
        String result = policyService.savePolicy(request);
        return ResponseEntity.ok(result);

    }

    @PutMapping("/update/policy/{id}")
    public ResponseEntity<PolicyResponse> updatePolicy(@PathVariable Long id, @RequestBody PolicyRequest request) {
        PolicyResponse response = policyService.updatePolicy(id, request);
        return ResponseEntity.ok(response);

    }



    @DeleteMapping("/deletePolicy/{id}")
    public ResponseEntity<String> deletePolicyById(@PathVariable Long id){
        String responce = policyService.deletePolicy(id);
        return  ResponseEntity.ok(responce);
    }
}

