package com.patientInfo.patientmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patientInfo.patientmgmt.dto.PatientDto;
import com.patientInfo.patientmgmt.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PatientController {

	@Autowired
	private PatientService patientService;
	
	@PostMapping("/patient")
	public PatientDto addPatient(@RequestBody PatientDto patientDto) {
		
		log.info("Calling api to add patient");
		return patientService.addPatient(patientDto);
	}
	
	@PutMapping("/patient")
	public PatientDto updatePatient(@RequestBody PatientDto patientDto) {
		
		log.info("Calling api to update patient");
		return patientService.updatePatient(patientDto);
	}
	
	@GetMapping("/patient")
	public List<PatientDto> getAllPatient() {
		
		log.info("Calling api to get all  patient");
		return patientService.getAllPatient();
	}
	
	@GetMapping("/patient/name/{name}")
	public PatientDto getAllPatientsByname(@PathVariable("name") String name) {
		
		log.info("Calling api to get patient by name");
		return patientService.getPatientByName(name);
	}
	
	@GetMapping("/patient/{id}")
	public PatientDto getProductById(@PathVariable("id") Long id) {
		
		log.info("Calling api to get patient by id");
		return patientService.getPatientById(id);
	}
	
	@DeleteMapping("/patient/{id}")
	public void deleteProductById(@PathVariable("id") Long id) {
		
		log.info("Calling api to delete patient by id");
		patientService.deletePatient(id);
	}
	
}
