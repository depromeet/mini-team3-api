package com.depromeet.service;

import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depromeet.models.dto.RegisterRequest;
import com.depromeet.models.dto.UserResponse;
import com.depromeet.models.entity.User;
import com.depromeet.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserResponse> getAllUser() {
		List<User> user = userRepository.findAll();
		List<UserResponse> list = new LinkedList<>();
		for(User u : user) {
			list.add(UserResponse.from(u));
		}
		
		return list;
	}
	
	public User addUser(RegisterRequest request) {
		return userRepository.save(User.from(request));
	}
}
