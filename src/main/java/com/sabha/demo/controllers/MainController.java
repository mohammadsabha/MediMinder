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

import com.sabha.demo.models.Doctor;
import com.sabha.demo.models.Patient;
import com.sabha.demo.models.User;
import com.sabha.demo.services.DoctorService;
import com.sabha.demo.services.MainService;
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
	MainService mainService;
	
@RequestMapping("/")
public String showLoginPage(Model model) {
return "LoginTest.jsp";
}





@GetMapping("/user/new")
public String newClinic1(HttpSession session, Model model,@ModelAttribute("user") User user) {
	
 return "admin.jsp";
}

@PostMapping("/user/new")
public String newClinic2(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("user", user);
        return "admin.jsp";
    } else {
        mainService.createUser(user);
        return "redirect:/user/new";
    }
}

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
