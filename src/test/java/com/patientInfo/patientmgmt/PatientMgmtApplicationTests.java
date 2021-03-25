package com.patientInfo.patientmgmt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patientInfo.patientmgmt.dto.PatientDto;
import com.patientInfo.patientmgmt.entity.PatientEntity;

public class PatientMgmtApplicationTests extends PatientServiceTestConfiguration {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getProductsList() throws Exception {
		String uri = "/patient";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
	}

	@Test
	public void createProduct() throws Exception {
		String uri = "/patient";
		PatientEntity patient = new PatientEntity();
		patient.setId(6L);
		patient.setName("Ginger");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		assertEquals(content, mapper.writeValueAsString(patient));
	}

	@Test
	public void updateProduct() throws Exception {
		String uri = "/patient";
		PatientDto patient = new PatientDto();
		patient.setId(1L);
		patient.setName("Lemon");
		String inputJson = super.mapToJson(patient);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		assertEquals(content, mapper.writeValueAsString(patient));
	}

	@Test
	public void deleteProduct() throws Exception {
		String uri = "/patient/1";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}

}
