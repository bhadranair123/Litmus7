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
	public Response insertUser(User user) throws UserServiceException {
		try {
			if (user.getAge() < 18 || user.getAge() > 60) {
				throw new InvalidAgeException("Error:Age must be between 18 and 60");
			} else if (!user.getEmail().contains("@")) {
				throw new InvalidEmailException("Error: Invalid email format. Must contain '@' and '.'.");
			} else if (user.getPassword().length() < 6) {
				throw new InvalidPasswordException(
						"Error: Password too weak. Must be at least 6 characters. Registration failed");
			} else {
				UserDao dao = new UserDao();
				Response response = new Response();
				try {
					response = dao.addNewUser(user);
				} catch (UserDataAccessException e) {
					throw new UserServiceException(
							"We are unable to provide the requested service at this moment" + e.getMessage());
				}
				return response;

			}
		} catch (InvalidAgeException e) {
			throw new UserServiceException(e.getMessage());
		}

		catch (InvalidEmailException e) {
			throw new UserServiceException(e.getMessage());
		} catch (InvalidPasswordException e) {
			throw new UserServiceException(e.getMessage());
		}

	}
}
