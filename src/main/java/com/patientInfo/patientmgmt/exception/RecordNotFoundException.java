package com.patientInfo.patientmgmt.exception;

public class RecordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1237456L;

	public RecordNotFoundException(String exception) {
		super(exception);
	}

}
