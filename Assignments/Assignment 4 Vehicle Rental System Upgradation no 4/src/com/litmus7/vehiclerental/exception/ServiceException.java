package com.litmus7.vehiclerental.exception;

public class ServiceException extends Exception {
	public ServiceException(String string) {
		super(string);
	}

	public ServiceException(String string,Throwable cause) {
		super(string, cause);
	}
}
