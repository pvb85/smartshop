package com.shopkeeper.exceptions;

public class UserNotFoundException extends Exception {


	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(final String message) {
		super(message);
	}
}