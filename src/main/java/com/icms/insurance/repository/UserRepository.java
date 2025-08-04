package com.icms.insurance.repository;

import com.icms.insurance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

 public  Optional<User> findByEmail(String email);

 public boolean  existsByEmail(String email);

 // public User findByEmail(String email);

}
