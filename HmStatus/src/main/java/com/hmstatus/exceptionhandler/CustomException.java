package com.hmstatus.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CustomException extends RuntimeException{
	
	private String getMessage;

	
	public CustomException(String getMessage) {
		super(getMessage);
	}

	public String getGetMessage() {
		return getMessage;
	}

	public void setGetMessage(String getMessage) {
		this.getMessage = getMessage;
	}
	
	

}
