package com.ticketexpress.application.errors;

public class NotFoundException extends RuntimeException{
	public NotFoundException(String message) {
		super(message);
	}
}
