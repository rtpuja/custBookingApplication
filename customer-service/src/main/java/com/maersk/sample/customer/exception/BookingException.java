package com.maersk.sample.customer.exception;

public class BookingException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public BookingException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
