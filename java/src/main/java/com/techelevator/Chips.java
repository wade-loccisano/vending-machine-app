package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Vendable {

	public Chips(String name, BigDecimal price, String category, String id, int quantity) {
		super(name, price, category, id, quantity);
	}

	public Chips() {
	}

	@Override
	public String getMessage() {
		return "Crunch Crunch, Yum!";
	}

}
