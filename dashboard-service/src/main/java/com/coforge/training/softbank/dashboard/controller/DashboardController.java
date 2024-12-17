package com.coforge.training.softbank.dashboard.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.training.softbank.dashboard.dto.TransactionSummaryDTO;
import com.coforge.training.softbank.dashboard.dto.UserDetailsDTO;
import com.coforge.training.softbank.dashboard.service.DashboardService;

/**
* User   : Singuluri.Kumar
* Date   : 16-Dec-2024
* Time   : 10:25:30 pm
* Project:dashboard-service
**/

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    @GetMapping("/transaction-history")
    public ResponseEntity<List<TransactionSummaryDTO>> getTransactionHistory(@RequestParam String accountNo, @RequestParam String upiId, @RequestParam String period) {
        List<TransactionSummaryDTO> transactions = dashboardService.getTransactionHistory(accountNo, upiId, period);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    
    @GetMapping("/user-details")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@RequestParam String accountNo) {
        UserDetailsDTO userDetails = dashboardService.getUserDetails(accountNo);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }
}
