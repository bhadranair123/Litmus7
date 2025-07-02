package com.litmus7.vehiclerental.exception;

public class DataAccessException extends Exception {
	public DataAccessException(String string) {
		super(string);
	}

	public DataAccessException(String string, Throwable cause) {
		super(string,cause);
	}
}
