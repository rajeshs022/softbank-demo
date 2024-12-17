package com.coforge.training.softbank.reg.dto;

import java.time.LocalDateTime;

/**
* User   : Singuluri.Kumar
* Date   : 15-Dec-2024
* Time   : 12:11:28 pm
* Project:registration-service
**/

public class AccountRequestDTO {

	private Long id;
    private String accountNo;
    private String accountType;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime approvedAt;
 
    // Getters and Setters
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getAccountNo() {
        return accountNo;
    }
 
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
 
    public String getAccountType() {
        return accountType;
    }
 
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
 
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
 
    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }
 
    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }

}
