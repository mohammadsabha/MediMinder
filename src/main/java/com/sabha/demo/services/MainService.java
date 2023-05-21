package com.sabha.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabha.demo.models.User;
import com.sabha.demo.repositories.RoleRepository;
import com.sabha.demo.repositories.UserRepo;

@Service
public class MainService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepository roleRepository;
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public void saveWithUserRole(User user) {
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepo.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }    
    
    // 3
    public User findByName(String name) {
        return userRepo.findByName(name);
    }
	
	
}
