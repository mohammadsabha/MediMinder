package com.sabha.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sabha.demo.models.Doctor;
import com.sabha.demo.models.Patient;
import com.sabha.demo.services.DoctorService;
import com.sabha.demo.services.PatientService;

@Controller
public class AppController {
	
	 @Autowired
	    private DoctorService doctorService;

	 @Autowired
	    private PatientService patientService;


	
	@GetMapping("/admin")
	public String admin() {
		return "admin.jsp";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		// Retrieve all doctors
        List<Doctor> doctors = doctorService.allDoctors();

        // Retrieve all patients
        List<Patient> patients = patientService.allPatients();

        // Add the doctors and patients to the model
        model.addAttribute("doctors", doctors);
        model.addAttribute("patients", patients);
		return "home.jsp";
	}
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@GetMapping("/doctorhome")
	public String doctorHome() {
		return "doctorhome.jsp";
	}
	
	
	
	
}
