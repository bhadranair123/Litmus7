package com.litmus7.retaildiscount.dto;

public class PremiumCustomer implements Discountable {
	public double[] applyDiscount(double totalAmount) {
		if (totalAmount > 5000) {
			double finalPayableAmount = 0.10 * totalAmount;
			double discount = totalAmount - finalPayableAmount;
			double[] amount = { discount, finalPayableAmount };
			return amount;
		} else {
			double finalPayableAmount = 0.07 * totalAmount;
			double discount = totalAmount - finalPayableAmount;
			double[] amount = { discount, finalPayableAmount };
			return amount;
		}
	}
}
