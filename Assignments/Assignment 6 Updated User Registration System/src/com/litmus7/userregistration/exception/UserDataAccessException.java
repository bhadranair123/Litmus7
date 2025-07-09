package com.litmus7.userregistration.exception;

public class UserDataAccessException extends Exception {
	public UserDataAccessException(String string) {
		super(string);
	}

	public UserDataAccessException(String string, Throwable cause) {
		super(string, cause);
	}
}
