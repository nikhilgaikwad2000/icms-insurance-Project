package com.icms.insurance.service;

import com.icms.insurance.entity.Claim;
import com.icms.insurance.entity.Policy;
import com.icms.insurance.entity.User;
import com.icms.insurance.repository.ClaimRepository;
import com.icms.insurance.repository.PolicyRepository;
import com.icms.insurance.repository.UserRepository;
import com.icms.insurance.request.ClaimRequest;
import com.icms.insurance.response.ClaimResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PolicyRepository policyRepo;

    @Autowired
    private ClaimRepository claimRepo;

    @Override
    public String submitClaim(ClaimRequest request, String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isEmpty()) {
            return "User Not Found.....!";
        }
        User user = userOptional.get();

        Optional<Policy> optionalPolicy = policyRepo.findById(request.getPolicyId());
        if (optionalPolicy.isEmpty()) {
            return "Policy Not Found";
        }
        Policy policy = optionalPolicy.get();

        boolean exists = claimRepo.existsByUserAndPolicy(user, policy);
        if (exists) {
            return "You have already submitted a claim for this policy.";
        }

        Claim claim = Claim.builder()
                .user(user)
                .policy(policy)
                .reason(request.getReason())
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .build();

        claimRepo.save(claim);

        return "Claim submitted successfully and is now pending review...";
    }

    @Override
    public List<ClaimResponce> getUserClaims(String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User Not Found");
        }

        User user = userOptional.get();
        List<Claim> claims = claimRepo.findByUser(user);

        return claims.stream().map(claim -> {
            ClaimResponce dto = new ClaimResponce();
            dto.setClaimId(claim.getClaimId());
            dto.setPolicyName(claim.getPolicy().getPolicyName());
            dto.setReason(claim.getReason());
            dto.setStatus(claim.getStatus());
            dto.setCreatedAt(claim.getCreatedAt());
            return dto;
        }).toList();
    }
}
