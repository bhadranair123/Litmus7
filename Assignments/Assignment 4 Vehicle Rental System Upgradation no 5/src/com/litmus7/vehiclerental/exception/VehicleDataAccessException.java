package com.litmus7.vehiclerental.exception;

public class VehicleDataAccessException extends Exception {
	public VehicleDataAccessException(String string) {
		super(string);
	}

	public VehicleDataAccessException(String string, Throwable cause) {
		super(string, cause);
	}
}
