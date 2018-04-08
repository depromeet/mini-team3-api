package com.depromeet.models.dto;

import com.depromeet.models.entity.User;

public class LoginRequest {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static LoginRequest from(User user) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setEmail(user.getEmail());
		loginRequest.setPassword(user.getPassword());
		return loginRequest;
	}
}
