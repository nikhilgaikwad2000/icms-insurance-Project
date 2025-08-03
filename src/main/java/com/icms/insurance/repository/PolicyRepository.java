package com.icms.insurance.repository;

import com.icms.insurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
