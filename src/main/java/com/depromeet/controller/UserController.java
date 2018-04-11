package com.depromeet.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.depromeet.exception.UnauthorizedException;
import com.depromeet.models.dto.LoginRequest;
import com.depromeet.models.dto.RegisterRequest;
import com.depromeet.models.dto.UserResponse;
import com.depromeet.models.entity.User;
import com.depromeet.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	@ResponseStatus(HttpStatus.OK)
	public List<UserResponse> getAllUsers() {
		return userService.getAllUser()
				.stream()
				.map(user -> UserResponse.from(user))
				.collect(Collectors.toList());
	}

	@PostMapping(path = "/login")
	@ResponseStatus(HttpStatus.OK)
	public UserResponse getUser(@RequestBody LoginRequest req) {
		User user = userService.getUser(req.getEmail(), req.getPassword());
		if (user == null) {
			throw new UnauthorizedException("아이디 또는 비밀번호가 틀렸습니다.");
		}
		
		return UserResponse.from(user);
	}

	@PostMapping(path = "/register")
	@ResponseStatus(HttpStatus.CREATED)
	public void register(@RequestBody RegisterRequest req) {
		userService.addUser(User.from(req));
	}
}
