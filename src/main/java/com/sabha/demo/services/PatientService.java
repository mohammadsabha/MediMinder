package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabha.demo.models.Patient;
import com.sabha.demo.repositories.PatientRepo;

@Service
public class PatientService {

	@Autowired
	private PatientRepo patientRepo;
	
	// return all patients
	public List<Patient> allPatients() {
		return patientRepo.findAll();
	}
	
	// add patient
	public Patient addPatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	// update patient
	public Patient updatePatient(Patient patient) {
		return patientRepo.save(patient);
	}
	
	// delete patient
	public void deletePatient(Long id) {
		patientRepo.deleteById(id);
	}
	
	// retrieve by id
	public Patient findPatientById(Long id) {
		Optional <Patient> optionalPatient = patientRepo.findById(id);
		if (optionalPatient.isPresent()) {
			return optionalPatient.get();
		} else {
			return null;
		}
	}
	
}
