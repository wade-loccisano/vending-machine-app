package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

public class MoneyTest {

	@SuppressWarnings("deprecation")
	@Test
	public void feedMoney_adds_1() throws FileNotFoundException {
		Money money = new Money();
		BigDecimal expected = new BigDecimal(1.00);
		BigDecimal actual = money.feedMoney(new BigDecimal(0.00), new BigDecimal(1.00));
		
		Assert.assertTrue(expected.compareTo(actual) == 0);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void feedMoney_adds_2() throws FileNotFoundException {
		Money money = new Money();
		BigDecimal expected = new BigDecimal(2.00);
		BigDecimal actual = money.feedMoney(new BigDecimal(0.00), new BigDecimal(2.00));
		
		Assert.assertTrue(expected.compareTo(actual) == 0);
	}
	@SuppressWarnings("deprecation")	
	@Test
	public void changeGiven_zeroes_out_balance() throws FileNotFoundException {
		Money money = new Money();
		BigDecimal expected = new BigDecimal(0.00);
		BigDecimal actual = money.changeGiven(new BigDecimal(1.00));
		
		Assert.assertTrue(expected.compareTo(actual) == 0);
	}

}
