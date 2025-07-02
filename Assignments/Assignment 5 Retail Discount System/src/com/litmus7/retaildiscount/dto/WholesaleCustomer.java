package com.litmus7.retaildiscount.dto;

public class WholesaleCustomer implements Discountable {
	public double[] applyDiscount(double totalAmount) {
		if (totalAmount > 10000) {
			double finalPayableAmount = 0.15 * totalAmount;
			double discount = totalAmount - finalPayableAmount;
			double[] amount = { discount, finalPayableAmount };
			return amount;
		} else {
			double finalPayableAmount = 0.10 * totalAmount;
			double discount = totalAmount - finalPayableAmount;
			double[] amount = { discount, finalPayableAmount };
			return amount;
		}
	}
}
