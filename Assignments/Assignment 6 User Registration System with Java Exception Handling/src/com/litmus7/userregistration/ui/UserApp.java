package com.litmus7.userregistration.ui;

import java.util.Scanner;
import com.litmus7.userregistration.controller.UserController;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.dto.Response;

public class UserApp {
	public static void main(String[] args) throws UserServiceException, UserDataAccessException {
		UserController controller = new UserController();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter username");
		String name = scanner.nextLine();
		System.out.println("Enter age");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter email");
		String email = scanner.nextLine();
		System.out.println("Enter password");
		String password = scanner.nextLine();
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		user.setPassword(password);

		Response response1 = new Response();
		response1 = controller.insertUser(user);
		if (response1.getStatusCode() != 400) {
			System.out.println(response1.getData());
		}

		Response response2 = new Response();
		response2 = controller.retrieveUser(name);
		if (response2.getStatusCode() != 400) {
			System.out.print("User details: ");
			System.out.println(response2.getData());
		}
	}
}
