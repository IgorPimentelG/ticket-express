package com.ticketexpress.domain.errors;

public class ValidationException extends RuntimeException {
	public ValidationException(String message) {
		super(message);
	}
}
