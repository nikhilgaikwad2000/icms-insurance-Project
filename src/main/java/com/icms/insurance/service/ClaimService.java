package com.icms.insurance.service;

import com.icms.insurance.request.ClaimRequest;
import com.icms.insurance.response.ClaimResponce;

import java.util.List;

public interface ClaimService {

    public String submitClaim(ClaimRequest request ,String email);

    public List<ClaimResponce> getUserClaims(String email);
}
