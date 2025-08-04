package com.icms.insurance.service;

import com.icms.insurance.entity.Eligibility;
import com.icms.insurance.entity.Policy;
import com.icms.insurance.entity.User;
import com.icms.insurance.repository.EligibilityRepository;
import com.icms.insurance.repository.PolicyRepository;
import com.icms.insurance.repository.UserRepository;
import com.icms.insurance.request.EligibilityRequest;
import com.icms.insurance.response.EligibilityResponce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EligibilityServiceImpl implements EligibilityService {

    @Autowired
    private EligibilityRepository eligibilityRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PolicyRepository policyRepo;


    @Override
    public EligibilityResponce checkEligibility(EligibilityRequest request) {

        Long userID = request.getUserID();
        Long policyID = request.getPolicyID();

        EligibilityResponce response = new EligibilityResponce();

        response.setUserID(userID);
        response.setPolicyID(policyID);

        User user = userRepo.findById(userID).orElse(null);

        Policy policy = policyRepo.findById(policyID).orElse(null);

        if (user == null && policy == null) {
            response.setEligible(false);
            response.setMessage("Invalid User ID or Policy ID.");
            return response;
        }
        response.setPolicyType(policy.getPolicyType());

        boolean isEligible = false;
        String message = "Not Eligible for this policy";

        switch (policy.getPolicyType().toLowerCase()) {
            case "health":
                if (user.getAge() < 60 && user.getIncome() > 30000) {
                    isEligible = true;
                    message = "Eligible For Health Policy";
                }
                break;
            case "life":
                if (user.getAge() >= 18 && user.getIncome() >= 50000) {
                    isEligible = true;
                    message = "Eligible For Life Policy";
                }
                break;
            case "vehicle":
                if (user.getIncome() > 10000) {
                    isEligible = true;
                    message = "Eligible for Vehicle Policy";
                }
                break;
            case "education":
                if (user.getAge() < 25 && user.getIncome() > 5000) {
                    isEligible = true;
                    message = "Eligible for education policy";
                }
                break;
            case "retirement":
                if (user.getAge() > 50 && user.getIncome() > 40000) {
                    isEligible = true;
                    message = "Eligible for retirement policy";
                }
                break;
            case "illness":
                if (user.getAge() <= 65 && user.getIncome() >= 35000) {
                    isEligible = true;
                    message = "Eligible for critical illness policy.";
                }
            default:
                message = "Unknown policy type.";

        }

        Eligibility eligibility = Eligibility.builder()
                .user(user)         // This is enough
                .policy(policy)
                .eligible(isEligible)
                .decisionDate(LocalDate.now())
                .reason(message)
                .build();


        eligibilityRepo.save(eligibility);


        response.setEligible(isEligible);
        response.setMessage(message);

        return response;


    }
}
