package com.litmus7.userregistration.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException(String string) {
		super(string);
	}

	public InvalidPasswordException(String string, Throwable cause) {
		super(string, cause);
	}
}
