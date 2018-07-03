package com.example.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignUpReq {
	// region -- Fields --

	@JsonProperty(value = "userName")
	private String userName;

	@JsonProperty(value = "password")
	private String password;

	@JsonProperty(value = "firstName")
	private String firstName;

	@JsonProperty(value = "lastName")
	private String lastName;

	@JsonProperty(value = "accountNo")
	private String accountNo;

	@JsonProperty(value = "phoneNo")
	private String phoneNo;

	@JsonProperty(value = "address")
	private String address;

	@JsonProperty(value = "remarks")
	private String remarks;

	// end

	// region -- Get set --

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	// end

	// region -- Methods --

	public UserSignUpReq() {
	}

	// end
}