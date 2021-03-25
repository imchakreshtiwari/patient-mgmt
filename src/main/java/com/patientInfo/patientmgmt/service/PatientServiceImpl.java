package com.patientInfo.patientmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientInfo.patientmgmt.dto.PatientDto;
import com.patientInfo.patientmgmt.entity.PatientEntity;
import com.patientInfo.patientmgmt.exception.RecordNotFoundException;
import com.patientInfo.patientmgmt.mapper.PatientMapper;
import com.patientInfo.patientmgmt.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientMapper patientMapper;

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public PatientDto addPatient(PatientDto patientDto) {

		log.info("Adding patient record to database with name {} ", patientDto.getName());
		PatientEntity patientEntity = patientMapper.toEntity(patientDto);
		return patientMapper.toDto(patientRepository.save(patientEntity));
	}

	@Override
	public PatientDto updatePatient(PatientDto patientDto) {

		log.info("Updating patient record to database with name {} ", patientDto.getName());
		PatientEntity updatePatientEntity = patientRepository.findById(patientDto.getId())
				.orElseThrow(() -> new RecordNotFoundException("Patient not found with id : " + patientDto.getId()));

		PatientEntity updatedPatientEntity = patientMapper.toEntityUpdate(patientDto, updatePatientEntity);
		return patientMapper.toDto(patientRepository.save(updatedPatientEntity));

	}

	@Override
	public List<PatientDto> getAllPatient() {

		List<PatientEntity> patients = patientRepository.findAll();
		log.info("Total number of patient fetched from db : {}", patients.size());

		return patientMapper.toDtos(patients);

	}

	@Override
	public PatientDto getPatientById(Long id) {
		
		log.info("Get patient record from database By Id");
		PatientEntity patientEntity = patientRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Patient not found with id : " + id));
		
		return patientMapper.toDto(patientEntity);
	}

	@Override
	public PatientDto getPatientByName(String name) {
		
		log.info("Get patient record from database By Id");
		PatientEntity patientEntity = patientRepository.findByName(name)
				.orElseThrow(() -> new RecordNotFoundException("Patient not found with name : " + name));
		
		return patientMapper.toDto(patientEntity);
	
	}

	@Override
	public void deletePatient(Long id) {
		
		log.info("delete patient record from database");
		PatientEntity patientEntity = patientRepository.findById(id)
				.orElseThrow(() -> new RecordNotFoundException("Patient not found with id : " + id));
		patientRepository.delete(patientEntity);
	}
}
