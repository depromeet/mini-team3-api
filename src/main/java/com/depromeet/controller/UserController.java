package com.depromeet.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.depromeet.models.dto.UserResponse;
import com.depromeet.service.UserService;

@Controller
@RequestMapping(path="/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(path="/user")
	public @ResponseBody List<UserResponse> getAllUsers() {
		return userService.getAllUser();
	}
}
