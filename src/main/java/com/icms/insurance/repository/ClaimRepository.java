package com.icms.insurance.repository;

import com.icms.insurance.entity.Claim;
import com.icms.insurance.entity.Policy;
import com.icms.insurance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Long> {

    public boolean existsByUserAndPolicy(User user, Policy policy);
    public List<Claim> findByUser(User user);

}
