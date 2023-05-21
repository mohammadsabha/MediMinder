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
import com.sabha.demo.models.LoginUser;
import com.sabha.demo.models.Patient;
import com.sabha.demo.models.User;
import com.sabha.demo.services.DoctorService;
import com.sabha.demo.services.PatientService;
import com.sabha.demo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
    private DoctorService doctorService;

 @Autowired
    private PatientService patientService;
	
	@Autowired
	private UserService userServ;
	
@RequestMapping("/")
public String showLoginPage(Model model) {
return "login.jsp";
}


//@GetMapping("/user/new")
//public String newClinic1(HttpSession session, Model model,@ModelAttribute("user") User user) {
//	
// return "admin.jsp";
//}
//
//@PostMapping("/user/new")
//public String newClinic2(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
//    if (result.hasErrors()) {
//        model.addAttribute("user", user);
//        return "admin.jsp";
//    } else {
//        userServ.createUser(user);
//        return "redirect:/user/new";
//    }
//}

@GetMapping("/admin")
public String admin() {
	return "admin.jsp";
}

@PostMapping("/register")
public String register(@Valid @ModelAttribute("newUser") User newUser, 
        BindingResult result, Model model, HttpSession session) {
    userServ.register(newUser, result);
    if(result.hasErrors()) {
        model.addAttribute("newLogin", new LoginUser());
        return "main.jsp";
    }
    session.setAttribute("user_id", newUser.getId());
    return "redirect:/login";
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

//@GetMapping("/")
//public String index() {
//	return "index.jsp";
//}

@GetMapping("/login")
public String login() {
	return "login.jsp";
}

@GetMapping("/doctorhome")
public String doctorHome() {
	return "doctorhome.jsp";
}

@GetMapping("/clinic")
public String clinic() {
	return "clinic.jsp";
}

@GetMapping("/createdoctor")
public String createDoctor() {
	return "createDoctor.jsp";
}

@GetMapping("/updatedoctor")
public String updateDoctor() {
	return "createDoctor.jsp";
}

@GetMapping("/createpatient")
public String createPatient() {
	return "createPatient.jsp";
}

@GetMapping("/updatePatient")
public String updatePatient() {
	return "updatePatient.jsp";
}

@GetMapping("/patient/{id}")
public String showPatient() {
	return "showPatient.jsp";
}

}
