package com.litmus7.userregistration.service;

import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dao.UserDao;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.InvalidPasswordException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.exception.UserServiceException;

public class UserService {
	UserDao userDao = null;
	private final int MIN_AGE = 18;
	private final int MAX_AGE = 60;

	public User registerUser(User user)
			throws UserServiceException, InvalidAgeException, InvalidEmailException, InvalidPasswordException {

		if (retrieveUser(user.getName()) != null) {
			throw new UserServiceException("User exists");
		}

		else if (user.getAge() < MIN_AGE || user.getAge() > MAX_AGE) {
			throw new InvalidAgeException("Error:Age must be between " + MIN_AGE + " and " + MAX_AGE);
		} else if (!user.getEmail().matches(".+@.+\\..+")) {
			throw new InvalidEmailException("Error: Invalid email format. Must contain '@' and '.'.");
		} else if (user.getPassword().length() < 6) {
			throw new InvalidPasswordException(
					"Error: Password too weak. Must be at least 6 characters. Registration failed");
		} else {
			userDao = new UserDao();
			try {
				User newUser = userDao.addNewUser(user);
				return newUser;
			} catch (UserDataAccessException e) {
				throw new UserServiceException(
						"We are unable to provide the requested service at this moment" + e.getMessage());
			}

		}

	}

	public User retrieveUser(String name) throws UserServiceException {
		userDao = new UserDao();
		try {
			User user = userDao.retrieveUser(name);
			return user;
		} catch (UserDataAccessException e) {
			throw new UserServiceException(
					"We are unable to provide the requested service at this moment" + e.getMessage());
		}
	}
}
