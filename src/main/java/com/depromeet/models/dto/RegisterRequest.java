package com.depromeet.models.dto;

import com.depromeet.models.entity.User;

public class RegisterRequest {
	private String email;
	private String password;
	private String nickname;
	private String phone;
	private String image;
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public static RegisterRequest from(User user) {
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEmail(user.getEmail());
		registerRequest.setPassword(user.getPassword());
		registerRequest.setNickname(user.getNickname());
		registerRequest.setPhone(user.getPhone());
		registerRequest.setImage(user.getImage());
		return registerRequest;
	}
}
