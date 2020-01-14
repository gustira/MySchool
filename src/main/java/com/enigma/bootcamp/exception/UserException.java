package com.enigma.bootcamp.exception;

public class UserException extends Exception{
	
	private Integer code;
	private String description;
	
	public UserException(Integer code, String description) {
		this.code= code;
		this.description= description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
