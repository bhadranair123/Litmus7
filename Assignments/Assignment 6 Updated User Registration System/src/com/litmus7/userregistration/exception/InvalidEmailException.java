package com.litmus7.userregistration.exception;

public class InvalidEmailException extends Exception {
	public InvalidEmailException(String string) {
		super(string);
	}

	public InvalidEmailException(String string, Throwable cause) {
		super(string, cause);
	}
}
