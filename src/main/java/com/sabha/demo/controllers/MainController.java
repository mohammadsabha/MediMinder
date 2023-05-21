package com.sabha.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sabha.demo.models.Clinic;
import com.sabha.demo.models.Doctor;
import com.sabha.demo.models.LoginClinic;
import com.sabha.demo.models.Patient;
import com.sabha.demo.models.User;
import com.sabha.demo.services.ClinicService;
import com.sabha.demo.services.DoctorService;
import com.sabha.demo.services.PatientService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
    private DoctorService doctorService;

 @Autowired
    private PatientService patientService;
	
	@Autowired
	private ClinicService clinicServ;
	
@RequestMapping("/")
public String showLoginPage(Model model) {
	model.addAttribute("newLogin", new LoginClinic());
return "login.jsp";
}


@GetMapping("/create")
public String admin(Model model) {
	List <Clinic> allClinics1=clinicServ.allClinic();
	model.addAttribute("allClinics1", allClinics1);
	model.addAttribute("newClinic", new Clinic());
	return "admin.jsp";
}

@PostMapping("/clinicregister")
public String register(@Valid @ModelAttribute("newClinic") Clinic newClinic, 
        BindingResult result, Model model, HttpSession session) {
    clinicServ.registerClinic(newClinic, result);
    if(result.hasErrors()) {
        model.addAttribute("newLogin", new LoginClinic());
        return "admin.jsp";
    }
    session.setAttribute("clinic_id", newClinic.getId());
    return "redirect:/create";
}

@PostMapping("/cliniclogin")
public String clinicLogin(@Valid @ModelAttribute("newLogin") LoginClinic newLogin, 
        BindingResult result, Model model, HttpSession session) {
    Clinic clinic = clinicServ.loginClinic(newLogin, result);
    if(result.hasErrors()) {
        model.addAttribute("newClinic", new Clinic());
        return "login.jsp";
    }
    session.setAttribute("clinic_id", clinic.getId());
    return "redirect:/clinic";
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




}
