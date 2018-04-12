package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User getByEmail(String email);
	
	public User getByLastName(String lastName);
	
}
