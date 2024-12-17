package com.coforge.training.softbank.reg.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * User   : Singuluri.Kumar
 * Date   : 14-Dec-2024
 * Time   : 8:30:10 pm
 * Project:registration-service
 **/

@Entity
@Table(name = "user_profiles")
@Getter
@Setter
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String mobileNumber;

	@Column(nullable = false)
	private String residentialAddress;

	@Column(nullable = false)
	private String permanentAddress;

	@Column(nullable = false, unique = true)
	private String aadharCard;

	private String occupation;
	// Getters and Setters
	
	@OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL)
	private AccountRequest accountRequest;
	 
	// Getter and Setter
	public AccountRequest getAccountRequest() {
	    return accountRequest;
	}
	 
	public void setAccountRequest(AccountRequest accountRequest) {
	    this.accountRequest = accountRequest;
	}
}
