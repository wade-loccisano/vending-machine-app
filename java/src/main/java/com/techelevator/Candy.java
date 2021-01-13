package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Vendable {

	public Candy(String name, BigDecimal price, String category, String id, int quantity) {
		super(name, price, category, id, quantity);
	}

	public Candy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Munch Munch, Yum!";
	}

}
