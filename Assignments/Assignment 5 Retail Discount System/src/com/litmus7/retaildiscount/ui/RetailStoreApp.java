package com.litmus7.retaildiscount.ui;

import java.util.Scanner;

import com.litmus7.retaildiscount.dto.RegularCustomer;
import com.litmus7.retaildiscount.dto.Discountable;
import com.litmus7.retaildiscount.dto.PremiumCustomer;
import com.litmus7.retaildiscount.dto.WholesaleCustomer;

public class RetailStoreApp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int customerType;
		double totalAmount;

		System.out.println("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
		customerType = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter total purchase amount: ");
		totalAmount = scanner.nextDouble();
		scanner.nextLine();
		Discountable discountable = null;

		switch (customerType) {
		case 1:
			discountable = new RegularCustomer();
			break;

		case 2:
			discountable = new PremiumCustomer();
			break;

		case 3:
			discountable = new WholesaleCustomer();
			break;
		default:
			System.out.println("Invalid Customer type");
			break;
		}
		double amount[] = discountable.applyDiscount(totalAmount);
		System.out.println("Customer Type: " + (customerType == 1 ? "Regular"
				: customerType == 2 ? "Premium" : customerType == 3 ? "Wholesale" : "Invalid"));
		System.out.println("Original Amount: ₹" + totalAmount);
		System.out.println("Discount Applied: ₹" + amount[0]);
		System.out.println("Final Payable Amount: ₹" + amount[1]);

	}
}