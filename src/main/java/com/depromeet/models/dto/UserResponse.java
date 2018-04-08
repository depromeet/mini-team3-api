package com.depromeet.models.dto;

import com.depromeet.models.entity.User;

public class UserResponse {
	
	private int userId;
	private String email;
	private String nickname;
	private String phone;
	private String image;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public static UserResponse from(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setUserId(user.getUserId());
		userResponse.setEmail(user.getEmail());
		userResponse.setNickname(user.getEmail());
		userResponse.setPhone(user.getPhone());
		userResponse.setImage(user.getImage());
		
		return userResponse;
	}
}
