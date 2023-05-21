package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sabha.demo.models.Doctor;
import com.sabha.demo.models.LoginDoctor;
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
	public Doctor registerDoctor(Doctor newDoctor, BindingResult result) {
        if(doctorRepo.findByEmail(newDoctor.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newDoctor.getPassword().equals(newDoctor.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newDoctor.getPassword(), BCrypt.gensalt());
            newDoctor.setPassword(hashed);

            return doctorRepo.save(newDoctor);
        }
    }
	public Doctor loginDoctor(LoginDoctor newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<Doctor> potentialDoctor = doctorRepo.findByEmail(newLogin.getEmail());
        if(!potentialDoctor.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        Doctor doctor = potentialDoctor.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), doctor.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return doctor;
        }
    }
}
