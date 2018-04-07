package com.depromeet.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.depromeet.models.dto.UserResponse;
import com.depromeet.models.entity.User;
import com.depromeet.repository.UserRepository;

@Transactional
@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<UserResponse> getAllUser() {
		return userRepository.findAll()
				.stream()
				.map(user -> UserResponse.from(user))
				.collect(Collectors.toList());
	}

	public UserResponse getUser(String email, String password) {
		User user = userRepository.findOneByEmailAndPassword(email, password);
		UserResponse userResponse = UserResponse.from(user);
		return userResponse;
	}
}
