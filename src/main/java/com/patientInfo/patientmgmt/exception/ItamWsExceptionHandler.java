package com.patientInfo.patientmgmt.exception;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class ItamWsExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add(request.getDescription(true));
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Server Error", details);
		log.error("Unknown exception occurred: "+error, ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(SocketTimeoutException.class)
	public final ResponseEntity<Object> handleSocketExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		details.add( request.getDescription(true));
		
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "App Session Expired", details);
		log.error("Unknown exception occurred: {}", ex);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add( request.getDescription(true));
        ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.toString(), "Record not found", details);
        log.error("RecordNotFoundException exception occurred: "+error, ex);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

	
	@ExceptionHandler(RecordAlreadyExistException.class)
    public final ResponseEntity<Object> handleRecordAlreadyExistException(RecordAlreadyExistException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        details.add( request.getDescription(true));
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.toString(), "Record already exist", details);
        log.error("RecordAlreadyExistException exception occurred: "+error, ex);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
	
}
