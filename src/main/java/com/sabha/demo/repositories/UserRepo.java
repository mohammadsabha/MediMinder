package com.sabha.demo.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabha.demo.models.User;
@Repository

public interface UserRepo extends CrudRepository<User, Long>{
	
	Optional<User> findById(Long id);
	
	List<User> findAll();

	User findByName(String name);

}
