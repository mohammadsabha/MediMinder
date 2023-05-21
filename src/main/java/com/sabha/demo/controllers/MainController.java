package com.sabha.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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



//--------------------------------start create doctor
@GetMapping("/createdoctor")
public String createDoctor(HttpSession session, Model model,@ModelAttribute("doctor") Doctor doctor) {

 return "createDoctor.jsp";
} 
@PostMapping("/createdoctor")
public String createDoctor2(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("doctor", doctor);
        return "createDoctor.jsp";
    } else {
    	doctorService.addDoctor(doctor);
        return "redirect:/createdoctor";
    }
}
//-----------------------------------end create doctor


//-------------------------------start update doctor
@GetMapping("/updatedoctor/{id}")
public String updateDoctor(HttpSession session, Model model,@ModelAttribute("doctor") Doctor doctor,@PathVariable("id") Long id) {

	Doctor doctor1 = doctorService.findDoctorById(id);
	model.addAttribute("doctor1", doctor1);
	 return "updateDoctor.jsp";
}

@PutMapping("/updatedoctor/{id}")
public String updateDoctor2(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model,@PathVariable("id") Long id) {
       if (result.hasErrors()) {
    	   Doctor doctor1 =doctorService.findDoctorById(id);

           model.addAttribute("doctor1", doctor1);
           return "updateDoctor.jsp";
       } else {
    	   doctorService.addDoctor(doctor);
           return "redirect:/updatedoctor/"+id;
       }
   }
//-----------------------------------------------end update doctor


//-----------------------------------------start create patient
@GetMapping("/createpatient")
public String createPatient(HttpSession session, Model model,@ModelAttribute("patient") Patient patient) {

 return "createPatient.jsp";
} 
@PostMapping("/createpatient")
public String createPatient2(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("patient", patient);
        return "createPatient.jsp";
    } else {
    	patientService.addPatient(patient);
        return "redirect:/createpatient";
    }
}
//--------------------------------------end create patient

//-----------------------------------------start update Patient
@GetMapping("/updatePatient/{id}")
public String updatePatient(HttpSession session, Model model,@ModelAttribute("patient") Patient patient,@PathVariable("id") Long id) {

	Patient patient1 = patientService.findPatientById(id);
	model.addAttribute("patient1", patient1);
	 return "updatePatient.jsp";
}

@PutMapping("/updatePatient/{id}")
public String updatePatient2(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model,@PathVariable("id") Long id) {
       if (result.hasErrors()) {
    	   Patient patient1 = patientService.findPatientById(id);

           model.addAttribute("patient1", patient1);
           return "updatePatient.jsp";
       } else {
    	   patientService.addPatient(patient);
           return "redirect:/updatePatient/"+id;
       }
   }
//-----------------------------------------end update Patient

//---------------------------------------------start delete doctor
@GetMapping("/deletedoctor/{id}")
public String deleteDoctor(@PathVariable("id") Long id) {
	doctorService.delelteDoctor(id);
	return "redirect:/clinic";
}
//---------------------------------------end delete doctor


//---------------------------------------------start delete patient
@GetMapping("/deletepatient/{id}")
public String deletePatient(@PathVariable("id") Long id) {
	patientService.deletePatient(id);
	return "redirect:/doctorhome";
}
//---------------------------------------end delete patient

}
