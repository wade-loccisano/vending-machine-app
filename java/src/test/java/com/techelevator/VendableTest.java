package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendableTest {

	
	File file = new File("test.csv");

	
	
	@Test
	public void buildVendableList_takes_a_file_and_builds_a_list_gum() throws IOException {

//		FileWriter writer = new FileWriter(file);
//		writer.write("D4|Triplemint|0.75|Gum");
//		writer.close();
		List<Vendable> expectedList = new ArrayList<>();

		expectedList.add(new Gum("Triplemint", new BigDecimal(0.75), "Gum", "D4", 5));

		List<Vendable> actualList = Vendable.buildVendableList(file);

		Assert.assertEquals(expectedList.get(0).getName(), actualList.get(0).getName());
		Assert.assertEquals(expectedList.get(0).getId(), actualList.get(0).getId());
		Assert.assertEquals(expectedList.get(0).getPrice(), actualList.get(0).getPrice());
		Assert.assertEquals(expectedList.get(0).getCategory(), actualList.get(0).getCategory());
		Assert.assertEquals(expectedList.get(0).getQuantity(), actualList.get(0).getQuantity());
		
	}
	
	@Test
	public void chips_message_is_accurate() {
		
		Chips chips = new Chips();
		String expected = "Crunch Crunch, Yum!";
		String actual = chips.getMessage();
		
		Assert.assertTrue(expected.contentEquals(actual));
	}
	
	@Test
	public void gum_message_is_accurate() {
		
		Gum gum = new Gum();
		String expected = "Chew Chew, Yum!";
		String actual = gum.getMessage();
		
		Assert.assertTrue(expected.contentEquals(actual));
	}
	
	@Test
	public void drink_message_is_accurate() {
		
		Drink drink = new Drink();
		String expected = "Glug Glug, Yum!";
		String actual = drink.getMessage();
		
		Assert.assertTrue(expected.contentEquals(actual));
	}
	
	@Test
	public void candy_message_is_accurate() {
		
		Candy candy = new Candy();
		String expected = "Munch Munch, Yum!";
		String actual = candy.getMessage();
		
		Assert.assertTrue(expected.contentEquals(actual));
	}
	
	@Test
	public void candy_constructor_works() {
		Candy candy = new Candy("crunchie", new BigDecimal(1.75) , "candy","B4", 5);
		Assert.assertEquals(candy.getName(), "crunchie");
	}
	@Test
	public void chips_constructor_works() {
		Chips chips = new Chips("crunchie", new BigDecimal(1.75) , "candy","B4", 5);
		Assert.assertEquals(chips.getName(), "crunchie");
	}
	@Test
	public void drink_constructor_works() {
		Drink drink = new Drink("crunchie", new BigDecimal(1.75) , "candy","B4", 5);
		Assert.assertEquals(drink.getName(), "crunchie");
	}
	
	@Test
	public void setQuantity_changes_vendable_quantity() {
		Gum gum = new Gum();
		int expected = 4;
		gum.setQuantity(4);
		int actual = gum.getQuantity();
		Assert.assertEquals(expected, actual); 
	}
	
	@Test
	public void setQuantity_changes_vendable_quantity_for_chip() {
		Chips chip = new Chips();
		int expected = 2;
		chip.setQuantity(2);
		int actual = chip.getQuantity();
		Assert.assertEquals(expected, actual); 
	}
	
	
	@Test
	public void renderVendables_prints_vendable() {
		List list = new ArrayList<>();
		Chips chip = new Chips("Potato Crisps", new BigDecimal(3.05), "Chips", "A1", 5);
		list.add(chip);
		
		String actual = Vendable.renderVendables(list);
		String expected = "A1| Potato Crisps | 3.05 | Chips | 5\n";
//		String actual =  ((Vendable) list.get(0)).getId() + "|" + ((Vendable) list.get(0)).getName() + "|" + ((Vendable) list.get(0)).getPrice().setScale(2, RoundingMode.UP) + "|" + ((Vendable) list.get(0)).getCategory() + "|" + ((Vendable) list.get(0)).getQuantity();
		
		Assert.assertEquals(expected, actual);
	}  
	
	
//	@Test
//	public void buildVendableList_takes_a_file_and_builds_a_list_chip() throws IOException {
//		List<Vendable> expectedList = new ArrayList<>();
//		expectedList.add(new Chips("Potato Crisps", new BigDecimal(3.05), "Chips", "A1", 5));
//
//		List<Vendable> actualList = Vendable.buildVendableList(file);
//
//		Assert.assertEquals(expectedList.get(1).getName(), actualList.get(1).getName());
//	}
	
	// dont test reading in from a file
}
