package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabha.demo.models.Doctor;
import com.sabha.demo.repositories.DoctorRepo;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	
	// return all doctors
	public List<Doctor> allDoctors() {
		return doctorRepo.findAll();
	}
	
	// add doctor 
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
	
	// update doctor 
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}
		
	// delete doctor
	public void delelteDoctor(Long id) {
		doctorRepo.deleteById(id);
	}
	
	// retrieve doctor by id
	public Doctor findDoctorById(Long id) {
	Optional <Doctor> optionalDoctor = doctorRepo.findById(id);
	if (optionalDoctor.isPresent()) {
		return optionalDoctor.get();
	} else {
		return null;
	}
	}
}
