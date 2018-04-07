package com.depromeet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.models.dto.LoginRequest;
import com.depromeet.models.dto.UserResponse;
import com.depromeet.service.UserService;

@RestController
@RequestMapping(path="/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/user")
	public @ResponseBody List<UserResponse> getAllUsers() {
		return userService.getAllUser();
	}
	
	@PostMapping(path="/login")
	public @ResponseBody UserResponse getUser(@RequestBody LoginRequest req) {
		return userService.getUser(req.getEmail(), req.getPassword());
	}
}
