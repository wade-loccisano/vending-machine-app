package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Vendable {

	public Drink(String name, BigDecimal price, String category, String id, int quantity) {
		super(name, price, category, id, quantity);
	}

	public Drink() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Glug Glug, Yum!";
	}

}
