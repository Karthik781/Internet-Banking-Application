package com.iba.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


	@ExceptionHandler(UserNotFoundException.class)
    protected ResponseEntity<Object> handleNoHandlerFoundException(UserNotFoundException ex, WebRequest request) {
		ExceptionResponse responce = new ExceptionResponse();
		responce.setMsg(ex.getMessage());
		responce.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity =	new ResponseEntity<Object>(responce, HttpStatus.NOT_FOUND);
		
		return entity;
    }
	
	@ExceptionHandler(CustomerNotFoundException.class)
    protected ResponseEntity<Object> handleNoHandlerFoundException(CustomerNotFoundException ex, WebRequest request) {
		ExceptionResponse responce = new ExceptionResponse();
		responce.setMsg(ex.getMessage());
		responce.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity =	new ResponseEntity<Object>(responce, HttpStatus.NOT_FOUND);
		
		return entity;
    }
	
	@ExceptionHandler(AdminNotFoundException.class)
    protected ResponseEntity<Object> handleNoHandlerFoundException(AdminNotFoundException ex, WebRequest request) {
		ExceptionResponse responce = new ExceptionResponse();
		responce.setMsg(ex.getMessage());
		responce.setDateTime(LocalDateTime.now());
		ResponseEntity<Object> entity =	new ResponseEntity<Object>(responce, HttpStatus.NOT_FOUND);
		
		return entity;
    }
	
	@ExceptionHandler(NomineeNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions (NomineeNotFoundException exception, WebRequest webRequest){
		ExceptionResponse response =new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMsg(exception.getMessage());
		ResponseEntity<Object> entity= new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions (AccountNotFoundException exception, WebRequest webRequest){
		ExceptionResponse response =new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMsg(exception.getMessage());
		ResponseEntity<Object> entity= new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(TransactionNotFoundException.class)
	public ResponseEntity<Object> handlerExceptions (TransactionNotFoundException exception, WebRequest webRequest){
		ExceptionResponse response =new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMsg(exception.getMessage());
		ResponseEntity<Object> entity= new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
		return entity;
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			
			errors.put(fieldName, errorMessage);
		});
		
		ResponseEntity<Object> entity =	 new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
		return entity;
	}
	
    
}