package com.litmus7.vehiclerental.exception;

public class ServiceException extends Exception {
	public ServiceException(String string) {
		super(string);
	}

	public ServiceException(String string, Exception DataAccessException) {
		super(string);
	}
}
