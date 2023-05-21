package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabha.demo.models.Appointment;
import com.sabha.demo.repositories.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired
	AppointmentRepository appointmentRepo;
	
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}
	
	public List<Appointment> allAppointments(){
		return appointmentRepo.findAll();
	}
	 
    
    
    public Appointment findAppointment(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepo.findById(id);
        if(optionalAppointment.isPresent()) {
            return optionalAppointment.get();
        } else {
            return null;
        }
    }
}
