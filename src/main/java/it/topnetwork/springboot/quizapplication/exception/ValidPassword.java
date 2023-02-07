package it.topnetwork.springboot.quizapplication.exception;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

	 String message() default "La Password deve contenere minimo 8 caratteri, dei quali almeno un carattere maiuscolo, uno minuscolo e uno speciale";
	 
	 Class<?>[] groups() default {};

	 Class<? extends Payload>[] payload() default {};
	
}
