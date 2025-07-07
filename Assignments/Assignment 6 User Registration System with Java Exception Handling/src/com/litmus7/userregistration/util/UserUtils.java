package com.litmus7.userregistration.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class UserUtils {
	public Connection connectWithDB() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/work", "root", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}