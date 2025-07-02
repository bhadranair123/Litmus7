package com.litmus7.retaildiscount.dto;

public class RegularCustomer implements Discountable {

	@Override
	public double[] applyDiscount(double totalAmount) {
		double finalPayableAmount = 0.05 * totalAmount;
		double discount = totalAmount - finalPayableAmount;
		double[] amount = { discount, finalPayableAmount };
		return amount;
	}

}
