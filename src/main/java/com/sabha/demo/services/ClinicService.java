package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.sabha.demo.models.Clinic;
import com.sabha.demo.models.LoginClinic;
import com.sabha.demo.repositories.ClinicRepo;

@Service
public class ClinicService {
	
	@Autowired
	ClinicRepo clinicRepo;
	
	
	
	public Clinic createClinic(Clinic clinic) {
		return clinicRepo.save(clinic);
	}
	
	public List<Clinic> allClinic(){
		return clinicRepo.findAll();
	}
	 
    
    
    public Clinic findClinic(Long id) {
        Optional<Clinic> optionalClinic = clinicRepo.findById(id);
        if(optionalClinic.isPresent()) {
            return optionalClinic.get();
        } else {
            return null;
        }
    }
    
    
    // 3
    
	
    public Clinic registerClinic(Clinic newClinic, BindingResult result) {
        if(clinicRepo.findByEmail(newClinic.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newClinic.getPassword().equals(newClinic.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newClinic.getPassword(), BCrypt.gensalt());
            newClinic.setPassword(hashed);

            return clinicRepo.save(newClinic);
        }
    }
	
	public Clinic loginClinic(LoginClinic newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<Clinic> potentialClinic = clinicRepo.findByEmail(newLogin.getEmail());
        if(!potentialClinic.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        Clinic clinic = potentialClinic.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), clinic.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return clinic;
        }
    }
    
	
}
