package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Vendable {

	public Gum(String name, BigDecimal price, String category, String id, int quantity) {
		super(name, price, category, id, quantity);
	}

	public Gum() {

	}

	@Override
	public String getMessage() {
		return "Chew Chew, Yum!";
	}

}
