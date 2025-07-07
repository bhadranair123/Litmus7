package com.litmus7.userregistration.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import com.litmus7.userregistration.util.UserUtils;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.dto.Response;

public class UserDao {
	public Response<Object> addNewUser(User user) throws UserDataAccessException {
		try {
			UserUtils utils = new UserUtils();
			Connection myConnection = utils.connectWithDB();
			String name = user.getName();
			int age = user.getAge();
			String email = user.getEmail();
			String password = user.getPassword();
			String sql = "insert into users values (?,?,?,?)";
			PreparedStatement statement = myConnection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.execute();
			Response response = new Response();
			response.setData("Registration successful!");
			response.setStatusCode(response.getSUCCESS_STATUS_CODE());
			return response;
		} catch (SQLException e) {
			throw new UserDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
	}

	public Response<Object> retrieveUser(String name) throws UserDataAccessException {
		try {
			UserUtils utils = new UserUtils();
			Connection myConnection = utils.connectWithDB();
			String sql = "select age,email,password from users where username=?";
			PreparedStatement statement = myConnection.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int age = resultSet.getInt(1);
				String email = resultSet.getString(2);
				String password = resultSet.getString(3);

				User user = new User();
				user.setName(name);
				user.setAge(age);
				user.setEmail(email);
				user.setPassword(password);
				Response response = new Response();
				response.setData(user);
				response.setStatusCode(response.getSUCCESS_STATUS_CODE());
				return response;
			}

		} catch (SQLException e) {
			throw new UserDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
		Response response = new Response();
		response.setErrorCode("Unable to retrieve user data");
		response.setStatusCode(response.getERROR_STATUS_CODE());
		return response;
	}
}
