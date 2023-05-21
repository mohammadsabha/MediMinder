package com.sabha.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sabha.demo.models.Appointment;
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{
Optional<Appointment> findById(Long id);
	
	List<Appointment> findAll();


}
