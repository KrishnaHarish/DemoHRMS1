package net.project.hrms.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public  class WorkExpResourceNotFoundException extends RuntimeException{
	
	public WorkExpResourceNotFoundException(String message) {
		super(message);

}
}