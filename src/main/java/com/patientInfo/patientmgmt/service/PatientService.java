package com.patientInfo.patientmgmt.service;

import java.util.List;

import com.patientInfo.patientmgmt.dto.PatientDto;

public interface PatientService {

	public PatientDto addPatient(PatientDto patientDto);
	
	public PatientDto updatePatient(PatientDto patientDto);
	
	public List<PatientDto> getAllPatient();
	
	public PatientDto getPatientById(Long id);
	
	public PatientDto getPatientByName(String name);
	
	public void deletePatient(Long id);
}
