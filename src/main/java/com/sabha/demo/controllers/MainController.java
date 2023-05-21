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

import com.sabha.demo.models.Clinic;
import com.sabha.demo.models.Doctor;

import com.sabha.demo.models.LoginDoctor;

import com.sabha.demo.models.LoginClinic;

import com.sabha.demo.models.Patient;
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

public String showIndex(Model model) {
  model.addAttribute("newLogin", new LoginClinic());
return "index.jsp";

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



@GetMapping("/login")
public String login(Model model) {
	model.addAttribute("newUser", new User());
    model.addAttribute("newLogin", new LoginUser());
	return "login.jsp";
}




@PostMapping("/login")
public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
        BindingResult result, Model model, HttpSession session) {
    
    // Add once service is implemented:
	 User user = userServ.login(newLogin, result);
    // User user = userServ.login(newLogin, result);

    if(result.hasErrors()) {
        model.addAttribute("newUser", new User());
        return "index.jsp";
    }
    session.setAttribute("user_id", user.getId());
    return "redirect:/home";
}
//----------------------------start doctor login
@GetMapping("/doctorlogin")
public String doctorLogin(Model model) {
	model.addAttribute("newDoctor", new Doctor());
    model.addAttribute("newLoginDoctor", new LoginDoctor());
	return "doctorLogin.jsp";
}

	//@PostMapping("/doctorLogin")
	//public String doctorLogin(@Valid @ModelAttribute("newLoginDoctor") LoginDoctor newLoginDoctor, 
	//        BindingResult result, Model model, HttpSession session) {
	//    
	//    // Add once service is implemented:
	//	 Doctor doctor = doctorService.login(newLoginDoctor, result);
	//    // User user = userServ.login(newLogin, result);
	//
	//    if(result.hasErrors()) {
	//        model.addAttribute("newDoctor", new Doctor());
	//        return "index.jsp";
	//    }
	//    session.setAttribute("doctor_id", doctor.getId());
	//    return "redirect:/home";
	//}
//---------------------------------end doctor login

//@GetMapping("/doctorhome")
//public String doctorHome(HttpSession session, Model model) {
//	List<Patient> allPatients = patientService.allPatients();
//	model.addAttribute("allPatients", allPatients);
//	return "doctorhome.jsp";
//}


@GetMapping("/clinic")
public String clinic(Model model) {
	List<Patient> allPatients = patientService.allPatients();
	model.addAttribute("allPatients", allPatients);
	
	List<Doctor> allDoctors = doctorService.allDoctors();
	model.addAttribute("allDoctors", allDoctors);
	return "home.jsp";
}



//--------------------------------start create doctor
@GetMapping("/createdoctor")
public String createDoctor(HttpSession session, Model model,@ModelAttribute("doctor") Doctor doctor) {
 return "createdoctor.jsp";
} 
@PostMapping("/createdoctor")
public String createDoctor2(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult result, Model model) {
    if (result.hasErrors()) {
        model.addAttribute("doctor", doctor);
        return "createdoctor.jsp";
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

           model.addAttribute("doctor", doctor1);
           return "updateDoctor.jsp";
       } else {
    	   doctorService.addDoctor(doctor);
           return "redirect:/updatedoctor/"+id;
       }
   }
//-----------------------------------------------end update doctor


//-----------------------------------------start create patient
@GetMapping("/doctorhome")
public String createPatient(HttpSession session, Model model,@ModelAttribute("patient") Patient patient) {
	List<Patient> allPatients = patientService.allPatients();
	model.addAttribute("allPatients", allPatients);
 return "doctorhome.jsp";
} 
	@PostMapping("/createPatient")
	public String createPatient2(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        model.addAttribute("patient", patient);
	    	List<Patient> allPatients = patientService.allPatients();
	    	model.addAttribute("allPatients", allPatients);
	        return "doctorhome.jsp";
	    } else {
	    	patientService.addPatient(patient);
	        return "redirect:/doctorhome";
	    }
	}
//--------------------------------------end create patient

//______________________________________start patient page
@GetMapping("/patient/{id}")
public String patientPage(@PathVariable("id") Long id , Model model) {
Patient patient1 = patientService.findPatientById(id);
model.addAttribute("patient", patient1);
return "patientpage.jsp";
}

//-----------------------------------------start update Patient

@GetMapping("/updatePatient/{id}")
public String updatePatient(HttpSession session, Model model,@ModelAttribute("patient") Patient patient,@PathVariable("id") Long id) {

	Patient patient1 = patientService.findPatientById(id);
	model.addAttribute("patient", patient1);
	 return "updatepatient.jsp";
}

@PutMapping("/updatePatient/{id}")
public String updatePatient2(@Valid @ModelAttribute("patient") Patient patient, BindingResult result, Model model,@PathVariable("id") Long id) {
       if (result.hasErrors()) {
    	   Patient patient1 = patientService.findPatientById(id);

           model.addAttribute("patient", patient1);
           return "updatepatient.jsp";
       } else {
    	   patientService.addPatient(patient);
           return "redirect:/updatepatient/"+id;
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
