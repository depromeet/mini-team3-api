package com.depromeet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.models.dto.RegisterRequest;
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
	
	@PostMapping(path="/register")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody void register(@RequestBody RegisterRequest request) {
		userService.addUser(request);
	}
}
