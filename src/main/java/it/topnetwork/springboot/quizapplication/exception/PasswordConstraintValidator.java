package it.topnetwork.springboot.quizapplication.exception;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
	
		Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]");
	    Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
	    Pattern lowerCasePatten = Pattern.compile("[a-z ]");
	    Pattern digitCasePatten = Pattern.compile("[0-9 ]");
	    
	    boolean flag=true;
	    
	    if (password.length() < 8) {
	        flag=false;
	    }
	    if (!specailCharPatten.matcher(password).find()) {
	    	System.out.println("Carattere digit");
	        flag=false;
	    }
	    if (!UpperCasePatten.matcher(password).find()) {
	        flag=false;
	    }
	    if (!lowerCasePatten.matcher(password).find()) { 
	        flag=false;
	    }
	    if (!digitCasePatten.matcher(password).find()) {  
	        flag=false;
	    }
		
		return flag;
	}

}
