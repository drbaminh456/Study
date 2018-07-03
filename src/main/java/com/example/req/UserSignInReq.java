package com.example.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignInReq {
	// region -- Fields --

	@JsonProperty(value = "userName")
	private String userName;

	@JsonProperty(value = "password")
	private String password;

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

	// end

	// region -- Methods --

	public UserSignInReq() {
	}

	// end
}