package com.sabha.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabha.demo.models.Doctor;
@Repository

public interface DoctorRepo extends CrudRepository<Doctor, Long>{
	
	Optional<Doctor> findById(Long id);
	
	List<Doctor> findAll();
	
	Optional<Doctor> findByEmail(String email);

}
