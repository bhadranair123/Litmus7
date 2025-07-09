package com.litmus7.retail.exception;

public class ProductServiceException extends Exception {

	public ProductServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductServiceException(String message) {
		super(message);
	}

}
