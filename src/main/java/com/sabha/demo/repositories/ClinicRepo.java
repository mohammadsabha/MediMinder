package com.sabha.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabha.demo.models.Clinic;
@Repository

public interface ClinicRepo extends CrudRepository<Clinic, Long>{
	
	Optional<Clinic> findById(Long id);
	
	List<Clinic> findAll();

	

}
