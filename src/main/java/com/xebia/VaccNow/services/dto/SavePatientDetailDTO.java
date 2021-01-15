package com.xebia.VaccNow.services.dto;

public class SavePatientDetailDTO {

	private String message;
	ErrorDto error;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorDto getError() {
		return error;
	}
	public void setError(ErrorDto error) {
		this.error = error;
	}
	
}
