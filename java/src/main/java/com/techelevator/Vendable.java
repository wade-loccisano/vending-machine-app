package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Vendable {
	private String name;
	private BigDecimal price;
	private String category;
	private String id;
	private int quantity;
	
	public Vendable() {
		
	}
	
	public Vendable(String name, BigDecimal price, String category, String id, int quantity) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.id = id;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}
	public String getId() {
		return id;
	}
	
	public abstract String getMessage();
	
	public static String renderVendables(List<Vendable> vendableList) {
		String output = "";
		for (int i = 0; i < vendableList.size(); i++) {
			output += (vendableList.get(i).getId() + "| " + vendableList.get(i).getName() + " | " 
		+ vendableList.get(i).getPrice().setScale(2, RoundingMode.UP) + " | " + vendableList.get(i).getCategory()
		+ " | " + vendableList.get(i).getQuantity() + "\n");
		}
		return output;
	}
	
	public static List<Vendable> buildVendableList(File file) throws FileNotFoundException {
		List<Vendable> vendingItems = new ArrayList<>();
		
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] splittedLine = line.split("\\|");
			String id = splittedLine[0];
			String name = splittedLine[1];
			BigDecimal price = new BigDecimal(splittedLine[2]); 
			String category = splittedLine[3];
			int quantity = 5;

			if (category.equals("Chip")) {
				vendingItems.add(new Chips(name, price, category, id, quantity));
			} else if (category.equals("Candy")) {
				vendingItems.add(new Candy(name, price, category, id, quantity));
			} else if (category.equals("Drink")) {
				vendingItems.add(new Drink(name, price, category, id, quantity));
			} else if (category.equals("Gum")) {
				vendingItems.add(new Gum(name, price, category, id, quantity));
			}
		} 
		inputFile.close();
		return vendingItems;
	}
}
