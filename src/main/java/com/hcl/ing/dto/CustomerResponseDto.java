package com.hcl.ing.dto;

public class CustomerResponseDto {

	private String message;
	private int statusCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResponseDto [message=" + message + ", statusCode=" + statusCode + "]";
	}

}
