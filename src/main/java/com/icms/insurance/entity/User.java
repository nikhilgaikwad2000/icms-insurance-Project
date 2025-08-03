package com.icms.insurance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private long userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    private LocalDate createDate;

    private String status;

    private Integer age;

    private Double income;




}
