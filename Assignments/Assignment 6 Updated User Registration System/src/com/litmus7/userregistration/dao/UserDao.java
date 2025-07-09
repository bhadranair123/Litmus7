package com.litmus7.userregistration.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import com.litmus7.userregistration.util.DBUtil;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.dto.Response;

public class UserDao {
	private Connection connection;

	public void connectToDB() throws SQLException {
		connection = DBUtil.getConnection();
	}

	public User addNewUser(User user) throws UserDataAccessException {
		try {
			connectToDB();
			String name = user.getName();
			int age = user.getAge();
			String email = user.getEmail();
			String password = user.getPassword();
			String sql = "insert into users values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.setString(3, email);
			statement.setString(4, password);
			statement.execute();
			return user;
		} catch (SQLException e) {
			throw new UserDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
	}

	public User retrieveUser(String userName) throws UserDataAccessException {
		try {

			connectToDB();
			String sql = "select age,email,password from users where username=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int age = resultSet.getInt(1);
				String email = resultSet.getString(2);
				String password = resultSet.getString(3);

				User user = new User();
				user.setName(userName);
				user.setAge(age);
				user.setEmail(email);
				user.setPassword(password);
				return user;
			}

		} catch (SQLException e) {
			throw new UserDataAccessException("Unable to access user database at the moment " + e.getMessage());

		}
		return null;

	}
}
