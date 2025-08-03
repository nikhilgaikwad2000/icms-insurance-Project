package com.icms.insurance.service;

import com.icms.insurance.request.PolicyRequest;
import com.icms.insurance.response.PolicyResponse;

import java.util.List;

public interface PolicyService {

    public String savePolicy(PolicyRequest request);
    public PolicyResponse updatePolicy(Long policyId, PolicyRequest request);
    public List<PolicyResponse> getAllPolicies();
    public PolicyResponse getPolicyById(Long policyId);
    public String deletePolicy(Long policyId);


}
