package com.litmus7.vehiclerental.dto;

import java.util.List;

public class Response<T, K, V> {

	private T statusCode;
	private K errorCode;
	private List<V> vehicles;

	public T getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(T statusCode) {
		this.statusCode = statusCode;
	}

	public K getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(K errorCode) {
		this.errorCode = errorCode;
	}

	public List<V> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<V> vehicles) {
		this.vehicles = vehicles;
	}

}
