package com.depromeet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depromeet.models.entity.User;
import com.depromeet.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUser(String email, String password) {
		return userRepository.findOneByEmailAndPassword(email, password);
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
}
