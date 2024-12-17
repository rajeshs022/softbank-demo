package com.coforge.training.softbank.reg.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.softbank.reg.dto.AccountRequestDTO;
import com.coforge.training.softbank.reg.model.AccountRequest;
import com.coforge.training.softbank.reg.model.UserProfile;
import com.coforge.training.softbank.reg.service.UserRegistrationService;

/**
* User   : Singuluri.Kumar
* Date   : 14-Dec-2024
* Time   : 8:58:36 pm
* Project:registration-service
**/

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {
 
    private final UserRegistrationService registrationService;
 
    public UserRegistrationController(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }
 
    @PostMapping("/create-account")
    public ResponseEntity<String> createAccountRequest(@RequestBody UserProfile userProfile,
                                                       @RequestParam String accountType) {
        String response = registrationService.createAccountRequest(userProfile, accountType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
 
    @PostMapping("/register")
    public ResponseEntity<String> registerForInternetBanking(@RequestParam String accountNo,
                                                             @RequestParam String username,
                                                             @RequestParam String loginPassword,
                                                             @RequestParam String transactionPassword,
                                                             @RequestParam String email,
                                                             @RequestParam String authPin) {
        String response = registrationService.registerForInternetBanking(accountNo, username, loginPassword,
                                                                         transactionPassword, email, authPin);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @GetMapping("/verify-account")
    public ResponseEntity<Boolean> verifyAccount(@RequestParam String accountNo) {
        boolean isApproved = registrationService.isAccountApproved(accountNo);
        return new ResponseEntity<>(isApproved, HttpStatus.OK);
    }
    
    @GetMapping("/account-requests")
    public ResponseEntity<List<AccountRequestDTO>> getPendingAccountRequests() {
        List<AccountRequest> pendingRequests = registrationService.getPendingAccountRequests();
        List<AccountRequestDTO> response = pendingRequests.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
 
    @PutMapping("/account-requests/approve/{accountNo}")
    public ResponseEntity<String> approveAccount(@PathVariable String accountNo) {
        boolean success = registrationService.approveAccount(accountNo);
        if (success) {
            return new ResponseEntity<>("Account approved successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
    }
 
    @PutMapping("/account-requests/reject/{accountNo}")
    public ResponseEntity<String> rejectAccount(@PathVariable String accountNo) {
        boolean success = registrationService.rejectAccount(accountNo);
        if (success) {
            return new ResponseEntity<>("Account rejected successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
        }
    }
 
    private AccountRequestDTO convertToDTO(AccountRequest accountRequest) {
        AccountRequestDTO dto = new AccountRequestDTO();
        dto.setId(accountRequest.getId());
        dto.setAccountNo(accountRequest.getAccountNo());
        dto.setAccountType(accountRequest.getAccountType());
        dto.setStatus(accountRequest.getStatus());
        dto.setCreatedAt(accountRequest.getCreatedAt());
        dto.setApprovedAt(accountRequest.getApprovedAt());
        return dto;
    }
}




