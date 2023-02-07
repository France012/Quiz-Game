package it.topnetwork.springboot.quizapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserNotFoundException.class) 
	public ResponseEntity<ErrorDetails> handleException(UserNotFoundException exc){
		
		// create a ErrorDetails instance
		ErrorDetails error = new ErrorDetails();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamps(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleException(Exception exc){
		
		// create a ErrorDetails instance
		ErrorDetails error = new ErrorDetails();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimestamps(System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> customHandleException(MethodArgumentNotValidException exc){
		
		// create a ErrorDetails instance
		ErrorDetails error = new ErrorDetails();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Validation error: " + exc.getBindingResult().getFieldError().getDefaultMessage());
		error.setTimestamps(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
