package com.litmus7.vehiclerental.exception;

public class VehicleServiceException extends Exception {
	public VehicleServiceException(String string) {
		super(string);
	}

	public VehicleServiceException(String string, Throwable cause) {
		super(string, cause);
	}
}
