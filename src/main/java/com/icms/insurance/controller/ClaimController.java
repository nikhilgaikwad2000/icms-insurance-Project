package com.icms.insurance.controller;

import org.springframework.web.bind.annotation.RestController;


import com.icms.insurance.request.ClaimRequest;
import com.icms.insurance.response.ClaimResponce;
import com.icms.insurance.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    // 🔹 POST: Submit Claim
    @PostMapping("/submit")
    public ResponseEntity<String> submitClaim(@RequestBody ClaimRequest request, Principal principal) {
        String email = principal.getName();  // fetch email from JWT token
        String result = claimService.submitClaim(request, email);
        return ResponseEntity.ok(result);
    }

    // 🔹 GET: View My Claims
    @GetMapping("/my")
    public ResponseEntity<List<ClaimResponce>> getMyClaims(Principal principal) {
        String email = principal.getName();
        List<ClaimResponce> claims = claimService.getUserClaims(email);
        return ResponseEntity.ok(claims);
    }

    @GetMapping("/my")
    public ResponseEntity<List<ClaimResponce>> getMyClaims1(Principal principal) {
        String email = principal.getName();
        List<ClaimResponce> claims = claimService.getUserClaims(email);
        return ResponseEntity.ok(claims);
    }
}
