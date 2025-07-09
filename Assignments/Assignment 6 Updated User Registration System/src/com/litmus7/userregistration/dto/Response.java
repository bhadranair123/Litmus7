package com.litmus7.userregistration.dto;

public class Response<T> {

	private int statusCode;
	private String errorCode;
	private T data;
	private final int SUCCESS_STATUS_CODE = 200;
	private final int ERROR_STATUS_CODE = 400;
	private final int USER_NOT_FOUND_CODE = 404;

	public int getUSER_NOT_FOUND_CODE() {
		return USER_NOT_FOUND_CODE;
	}

	public int getSUCCESS_STATUS_CODE() {
		return SUCCESS_STATUS_CODE;
	}

	public int getERROR_STATUS_CODE() {
		return ERROR_STATUS_CODE;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
