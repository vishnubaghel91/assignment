package com.bank.customerservice.response;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 7618476505499228608L;
	
	private String errorMessage;
	private long errorCode;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}
	
}
