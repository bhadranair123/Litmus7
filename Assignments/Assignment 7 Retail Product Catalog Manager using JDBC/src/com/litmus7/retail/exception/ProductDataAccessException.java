package com.litmus7.retail.exception;

public class ProductDataAccessException extends Exception {
	public ProductDataAccessException(String string) {
		super(string);
	}

	public ProductDataAccessException(String string, Throwable cause) {
		super(string, cause);
	}
}
