package com.sabha.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabha.demo.models.Patient;

@Repository

public interface PatientRepo extends CrudRepository<Patient, Long>{
	
	Optional<Patient> findById(Long id);
	
	List<Patient> findAll();

}
