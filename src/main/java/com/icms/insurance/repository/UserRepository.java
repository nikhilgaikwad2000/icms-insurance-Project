package com.icms.insurance.repository;

import com.icms.insurance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

 public  Optional<User> findByEmail(String email);

 public boolean  existsByEmail(String email);

 // public User findByEmail(String email);

}
