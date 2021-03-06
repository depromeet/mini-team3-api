package com.depromeet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.depromeet.models.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findOneByEmailAndPassword(String email, String password);
}
