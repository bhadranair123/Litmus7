package com.litmus7.userregistration.ui;

import java.util.Scanner;

import com.litmus7.userregistration.controller.UserController;
import com.litmus7.userregistration.dto.User;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.InvalidPasswordException;
import com.litmus7.userregistration.exception.UserDataAccessException;
import com.litmus7.userregistration.exception.UserServiceException;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.dao.UserDao;

public class UserApp {

	public static void main(String[] args) throws UserServiceException, UserDataAccessException, InvalidAgeException,
			InvalidEmailException, InvalidPasswordException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("---MENU---");
			System.out.println("1. Register User \r\n" + "2. View User \r\n" + "3.Exit");
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			UserController controller = new UserController();
			switch (choice) {

			case 1:
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
				response1 = controller.registerUser(user);
				if (response1.getStatusCode() == 200) {
					System.out.println(response1.getData());
				} else {
					System.out.println("User already exists. User Registration Failed");
				}
				break;
			case 2:
				System.out.println("Enter Username: ");
				String searchName = scanner.nextLine();
				Response response2 = new Response();
				response2 = controller.retrieveUser(searchName);
				if (response2.getStatusCode() == 200) {
					System.out.print("User details: ");
					System.out.println(response2.getData());
				} else if (response2.getStatusCode() == 404) {
					System.out.println("User does not exist.");
				} else {
					System.out.println("User retrieval failed.");
				}
				break;
			case 3:
				System.out.println("Exited the program");
				System.exit(0);

			default:
				System.out.println("Invalid choice");
			}

		}

	}

}
