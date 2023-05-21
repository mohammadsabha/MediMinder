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

import com.sabha.demo.models.Appointment;
import com.sabha.demo.models.Clinic;
import com.sabha.demo.models.Doctor;
import com.sabha.demo.models.LoginClinic;
import com.sabha.demo.models.LoginDoctor;
import com.sabha.demo.models.Patient;
import com.sabha.demo.models.User;
import com.sabha.demo.services.AppointmentService;
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
	
	@Autowired
	private AppointmentService appointmentServ;
	
@RequestMapping("/")

public String showIndex(Model model) {
  model.addAttribute("newLogin", new LoginClinic());
return "index.jsp";

}


@GetMapping("/admin")
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
        List <Clinic> allClinics1=clinicServ.allClinic();
    	model.addAttribute("allClinics1", allClinics1);
        return "admin.jsp";
    }
    session.setAttribute("clinic_id", newClinic.getId());
    return "redirect:/admin";
}

@GetMapping("/cliniclogin")
public String cliniclogin2(@ModelAttribute("newLogin") LoginClinic newLogin) {
	return "login.jsp";
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

@GetMapping("/clinic")
public String home(Model model,HttpSession session) {
	// Retrieve all doctors
	if (session.getAttribute("clinic_id") == null) {
		return "redirect:/logouty";
	}
	Clinic clinic=clinicServ.findClinic((Long) session.getAttribute("clinic_id"));
	
    List<Doctor> doctors = clinic.getDoctors();

    // Retrieve all patients
    List<Patient> patients = clinic.getPatients();

    // Add the doctors and patients to the model
    model.addAttribute("doctors", doctors);
    model.addAttribute("patients", patients);
	return "home.jsp";
	
	
}




//----------------------------start doctor login
@GetMapping("/doctorlogin")
public String doctorLogin(Model model,@ModelAttribute("newLoginDoctor") LoginDoctor newLoginDoctor) {
//	model.addAttribute("newDoctor", new Doctor());
//    model.addAttribute("newLoginDoctor", new LoginDoctor());
	return "doctorlogin.jsp";
}

	@PostMapping("/doctorlogin")
	public String doctorLogin(@Valid @ModelAttribute("newLoginDoctor") LoginDoctor newLoginDoctor, 
	        BindingResult result, Model model, HttpSession session) {
	    
	    // Add once service is implemented:
		 Doctor doctor = doctorService.loginDoctor(newLoginDoctor, result);
	    // User user = userServ.login(newLogin, result);
	
	    if(result.hasErrors()) {
	        model.addAttribute("newDoctor", new Doctor());
	        return "index.jsp";
	    }
	    session.setAttribute("doctor_id", doctor.getId());
	    return "redirect:/doctorhome";
	}
//---------------------------------end doctor login

//@GetMapping("/doctorhome")
//public String doctorHome(HttpSession session, Model model) {
//	List<Patient> allPatients = patientService.allPatients();
//	model.addAttribute("allPatients", allPatients);
//	return "doctorhome.jsp";
//}






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
    	doctorService.registerDoctor(doctor, result);
        return "redirect:/clinic";
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
	if (session.getAttribute("doctor_id") == null) {
		return "redirect:/logouty";
	}
	Doctor doctor=doctorService.findDoctorById((Long) session.getAttribute("doctor_id"));
	Long clinic_id=doctor.getClinic().getId();
	List<Patient> allPatients = doctor.getClinic().getPatients();
	model.addAttribute("allPatients", allPatients);
	model.addAttribute("clinic_id", clinic_id);
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
public String patientPage(@PathVariable("id") Long id , Model model,@ModelAttribute("appointment") Appointment appointment) {
Patient patient1 = patientService.findPatientById(id);
Long clinic_id=patient1.getClinic().getId();
model.addAttribute("patient", patient1);
model.addAttribute("clinic_id", clinic_id);
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

@GetMapping("/logouty")
	public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/";
}

@PostMapping("/addAppointment/{pt_id}")
public String createAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model,@PathVariable("pt_id") Long pt_id) {
    if (result.hasErrors()) {
        model.addAttribute("appointment", appointment);
        Patient patient1 = patientService.findPatientById(pt_id);
    	model.addAttribute("patient", patient1);
        return "doctorhome.jsp";
    } else {
    	appointmentServ.createAppointment(appointment);
        return "redirect:/patient/"+pt_id;
    }
}

}
