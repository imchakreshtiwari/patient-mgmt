package com.patientInfo.patientmgmt.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;

import com.patientInfo.patientmgmt.dto.PatientDto;
import com.patientInfo.patientmgmt.entity.PatientEntity;

@Mapper(componentModel = "spring")
public interface PatientMapper {

	default PatientEntity toEntity(PatientDto patientDto) {

		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setName(patientDto.getName());
		patientEntity.setGender(patientDto.getGender());
		patientEntity.setMobileNumber(patientDto.getMobileNumber());
		return patientEntity;

	}

	default PatientDto toDto(PatientEntity patientEntity) {

		PatientDto patientDto = new PatientDto();
		patientDto.setId(patientEntity.getId());
		patientDto.setName(patientEntity.getName());
		patientDto.setGender(patientEntity.getGender());
		patientDto.setMobileNumber(patientEntity.getMobileNumber());
		return patientDto;
	}
	
	default List<PatientDto> toDtos(List<PatientEntity> patientEntities) {

		List<PatientDto> patients = new ArrayList<>();
		for (PatientEntity patientEntity : patientEntities) {
			patients.add(toDto(patientEntity));
		}
		return patients;
	}
	
	default PatientEntity toEntityUpdate(PatientDto patientDto, PatientEntity patientEntity) {

		patientEntity.setName(patientDto.getName());
		patientEntity.setGender(patientDto.getGender());
		patientEntity.setMobileNumber(patientDto.getMobileNumber());
		return patientEntity;
	}
}
