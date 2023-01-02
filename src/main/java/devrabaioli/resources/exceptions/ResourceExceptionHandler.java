package devrabaioli.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import devrabaioli.services.exceptions.ObjectNotFoudException;
import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoudException.class)
	public ResponseEntity<StandardError> objectNotfound (ObjectNotFoudException e, HttpServletRequest cause){
		
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
		
	}

}
