package com.sabha.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabha.demo.models.User;
import com.sabha.demo.repositories.UserRepo;

@Service
public class MainService {
	
	@Autowired
	UserRepo userRepo;
	
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	

}
