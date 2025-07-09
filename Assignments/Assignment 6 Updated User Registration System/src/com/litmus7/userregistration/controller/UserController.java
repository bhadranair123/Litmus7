package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.service.UserService;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.InvalidPasswordException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.dao.UserDao;

public class UserController {
	public Response<Object> registerUser(User user)
			throws UserServiceException, InvalidAgeException, InvalidEmailException, InvalidPasswordException {
		Response response = new Response();
		try {
			UserService service = new UserService();
			User newUser = service.registerUser(user);
			response.setData(newUser);
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
		} catch (UserServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("User Registration Failed");
		}
		return response;
	}

	public Response<Object> retrieveUser(String name) throws UserServiceException {
		Response response = new Response();
		try {
			UserService service = new UserService();
			User user = service.retrieveUser(name);
			if (user != null) {
				response.setData(user);
				response.setStatusCode(response.getSUCCESS_STATUS_CODE());
			} else {
				response.setStatusCode(response.getUSER_NOT_FOUND_CODE());
			}

		} catch (UserServiceException e) {
			response.setStatusCode(response.getERROR_STATUS_CODE());
			response.setErrorCode("User Retrieval Failed");
		}
		return response;
	}
}