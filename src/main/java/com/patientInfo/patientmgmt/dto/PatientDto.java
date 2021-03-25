package com.patientInfo.patientmgmt.dto;

import lombok.Data;

@Data
public class PatientDto {

	private Long id;

	private String name;
	
	private String gender;
	private String mobileNumber;
}
