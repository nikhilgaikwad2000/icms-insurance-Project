package com.icms.insurance.service;

import com.icms.insurance.entity.Policy;
import com.icms.insurance.repository.PolicyRepository;
import com.icms.insurance.request.PolicyRequest;
import com.icms.insurance.response.PolicyResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyRepository policyRepo;



    @Transactional
    @Override
    public String savePolicy(PolicyRequest request) {

        Policy policy = new Policy();

        policy.setPolicyName(request.getPolicyName());
        policy.setPolicyType(request.getPolicyType());
        policy.setCoverageAmount(request.getCoverageAmount());
        policy.setStatus(request.getStatus());
        policy.setPremium(request.getPremium());
        policy.setCreatedDate(LocalDate.now());
        policy.setDescription(request.getDescription());

        policyRepo.save(policy);
        return "Policy saved successfully";
    }

    @Override
    public PolicyResponse updatePolicy(Long policyId, PolicyRequest request) {

        Optional<Policy> optionalPolicy = policyRepo.findById(policyId);

        if (optionalPolicy.isPresent()) {

            Policy policy1 = optionalPolicy.get();


            policy1.setPolicyName(request.getPolicyName());
            policy1.setPolicyType(request.getPolicyType());
            policy1.setCoverageAmount(request.getCoverageAmount());
            policy1.setStatus(request.getStatus());
            policy1.setPremium(request.getPremium());
            policy1.setCreatedDate(request.getCreatedDate());
            policy1.setDescription(request.getDescription());

            Policy updatedPolicy = policyRepo.save(policy1);

            PolicyResponse response = new PolicyResponse();

            response.setPolicyId(updatedPolicy.getPolicyId());
            response.setPolicyName(updatedPolicy.getPolicyName());
            response.setPolicyType(updatedPolicy.getPolicyType());
            response.setCoverageAmount(updatedPolicy.getCoverageAmount());
            response.setStatus(updatedPolicy.getStatus());
            response.setPremium(updatedPolicy.getPremium());
            response.setCreatedDate(updatedPolicy.getCreatedDate());
            response.setDescription(updatedPolicy.getDescription());

            return response;

        }
        return null;
    }

    @Override
    public List<PolicyResponse> getAllPolicies() {

        List<Policy> policies = policyRepo.findAll();

        List<PolicyResponse> responses=new ArrayList<>();

        for(Policy policy:policies){
            PolicyResponse response = new PolicyResponse();
            response.setPolicyId(policy.getPolicyId());
            response.setPolicyName(policy.getPolicyName());
            response.setPolicyType(policy.getPolicyType());
            response.setCoverageAmount(policy.getCoverageAmount());
            response.setStatus(policy.getStatus());
            response.setPremium(policy.getPremium());
            response.setCreatedDate(policy.getCreatedDate());
            response.setDescription(policy.getDescription());

            responses.add(response);
        }


        return responses;
    }

    @Override
    public PolicyResponse getPolicyById(Long policyId) {
        Optional<Policy> optionalPolicy = policyRepo.findById(policyId);
        if(optionalPolicy.isPresent()){

            Policy policy2 = optionalPolicy.get();

            PolicyResponse response=new PolicyResponse();

            response.setPolicyId(policy2.getPolicyId());
            response.setPolicyName(policy2.getPolicyName());
            response.setPolicyType(policy2.getPolicyType());
            response.setCoverageAmount(policy2.getCoverageAmount());
            response.setStatus(policy2.getStatus());
            response.setPremium(policy2.getPremium());
            response.setCreatedDate(policy2.getCreatedDate());
            response.setDescription(policy2.getDescription());

            return response;

        }
        return null;
    }

    @Override
    public String deletePolicy(Long policyId) {
        policyRepo.deleteById(policyId);
        return "Policy Delete Successfully";
    }
}
