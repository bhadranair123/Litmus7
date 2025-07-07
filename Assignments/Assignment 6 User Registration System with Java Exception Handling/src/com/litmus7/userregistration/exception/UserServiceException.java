package com.litmus7.userregistration.exception;

public class UserServiceException extends Exception {
	public UserServiceException(String string) {
		super(string);
	}

	public UserServiceException(String string, Throwable cause) {
		super(string, cause);
	}
}
