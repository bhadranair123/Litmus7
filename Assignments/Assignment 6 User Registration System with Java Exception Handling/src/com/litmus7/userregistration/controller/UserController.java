package com.litmus7.userregistration.controller;

import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.service.UserService;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.dao.UserDao;

public class UserController {
	public Response<Object> insertUser(User user) throws UserServiceException {
		UserService service = new UserService();
		Response response = new Response();
		response = service.insertUser(user);
		return response;
	}

	public Response<Object> retrieveUser(String name) throws UserDataAccessException {
		UserDao dao = new UserDao();
		Response response = new Response();
		response = dao.retrieveUser(name);
		return response;
	}
}
