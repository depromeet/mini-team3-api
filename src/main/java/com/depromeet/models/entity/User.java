package com.depromeet.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

import com.depromeet.models.dto.LoginRequest;
import com.depromeet.models.dto.RegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id") private int userId;
	
	@Column(name = "email") private String email;
	@Column(name = "password") private String password;
	@Column(name = "nickname") private String nickname;
	@Column(name = "phone") private String phone;
	@Column(name = "image") private String image;
	
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
	
	public static User from(RegisterRequest req) {
		User user = new User();
		user.setEmail(req.getEmail());
		user.setPassword(req.getPassword());
		user.setNickname(req.getNickname());
		user.setPhone(req.getPhone());
		user.setImage(req.getImage());
		
		return user;
	}
}
