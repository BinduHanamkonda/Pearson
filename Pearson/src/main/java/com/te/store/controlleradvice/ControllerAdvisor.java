package com.te.store.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.te.store.dto.StoreResponse;
import com.te.store.mycustomexception.BlankInput;
import com.te.store.mycustomexception.InvalidInput;

@RestControllerAdvice
public class ControllerAdvisor {
		
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InvalidInput.class)
	public ResponseEntity<StoreResponse> interalServerException(InvalidInput exception){
		StoreResponse response = new StoreResponse(404, "Unsuccessful", exception.getMessage());
		return new ResponseEntity<StoreResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	@ExceptionHandler(BlankInput.class)
	public ResponseEntity<StoreResponse> resourceNotFoundException(BlankInput exception){
		StoreResponse response = new StoreResponse(404, "Unsuccessful", exception.getMessage());
		return new ResponseEntity<StoreResponse>(response,HttpStatus.NOT_FOUND);
	}

}
