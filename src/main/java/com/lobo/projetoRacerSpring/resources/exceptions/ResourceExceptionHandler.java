package com.lobo.projetoRacerSpring.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lobo.projetoRacerSpring.services.exceptions.DataIntegrityViolationException;
import com.lobo.projetoRacerSpring.services.exceptions.ObjectnotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectnotFoundException (ObjectnotFoundException ex,
			HttpServletRequest request){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Objeto não localizado",
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException (DataIntegrityViolationException ex,
			HttpServletRequest request){
		
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de Dados",
				ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
