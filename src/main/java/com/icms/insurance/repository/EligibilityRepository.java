package com.icms.insurance.repository;

import com.icms.insurance.entity.Eligibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityRepository extends JpaRepository<Eligibility, Long> {

}
