package com.icms.insurance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class    Policy {

    @Id
    @GeneratedValue
    private long policyId;

    private  String policyName;
    private  String policyType;
    private String description;

    private Double coverageAmount;
    private Double premium;

    private String status;
    private LocalDate createdDate;

    public Policy(Double coverageAmount, LocalDate createdDate, String description, long policyId, String policyName, String policyType, Double premium, String status) {
        this.coverageAmount = coverageAmount;
        this.createdDate = createdDate;
        this.description = description;
        this.policyId = policyId;
        this.policyName = policyName;
        this.policyType = policyType;
        this.premium = premium;
        this.status = status;
    }

    public Double getCoverageAmount() {
        return coverageAmount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public String getDescription() {
        return description;
    }

    public long getPolicyId() {
        return policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public Double getPremium() {
        return premium;
    }

    public String getStatus() {
        return status;
    }

    public void setCoverageAmount(Double coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "coverageAmount=" + coverageAmount +
                ", policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                ", policyType='" + policyType + '\'' +
                ", description='" + description + '\'' +
                ", premium=" + premium +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public Policy() {
        // No-args constructor required by JPA
    }
}
