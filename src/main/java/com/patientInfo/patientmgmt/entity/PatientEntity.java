package com.patientInfo.patientmgmt.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	private String gender;
	private String mobileNumber;
	
	@Column(name = "created_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Calendar createdDate;

	@UpdateTimestamp
	private Calendar lastModifiedDate;
}
