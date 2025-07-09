package com.litmus7.userregistration.exception;

public class InvalidAgeException extends Exception {
	public InvalidAgeException(String string) {
		super(string);
	}

	public InvalidAgeException(String string, Throwable cause) {
		super(string, cause);
	}
}
