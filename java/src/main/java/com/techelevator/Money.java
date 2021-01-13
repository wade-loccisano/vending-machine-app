package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Money {
	
	private final BigDecimal QUARTER_VALUE = new BigDecimal(.25); 
	private final BigDecimal DIME_VALUE = new BigDecimal(.10);
	private final BigDecimal NICKEL_VALUE = new BigDecimal(.05);
	private final BigDecimal ZERO = new BigDecimal(0.00);

	public BigDecimal feedMoney(BigDecimal balance, BigDecimal amount) throws FileNotFoundException {
		balance = balance.add(amount);
		String stringToLog = LocalDateTime.now().toString() +  " FEED MONEY: $" + amount + "  $" + balance;
		VMLogger.log(stringToLog);
		return balance;
	}
	
	
	public BigDecimal changeGiven(BigDecimal balance) throws FileNotFoundException {
		int quarterAmount = 0;
		int dimeAmount = 0;
		int nickelAmount = 0;
		BigDecimal totalChange = balance;
	
		while (balance.compareTo(ZERO) > 0) {
			if (balance.compareTo(QUARTER_VALUE) > -1) {
				balance = balance.setScale(2, RoundingMode.UP);
				balance = balance.subtract(QUARTER_VALUE);
				quarterAmount++;
			}
			else if (balance.compareTo(DIME_VALUE) > -1) {
				balance = balance.setScale(2, RoundingMode.UP);
				balance = balance.subtract(DIME_VALUE);
				dimeAmount++;
			} 
			else if (balance.compareTo(NICKEL_VALUE) >= -1) {
				balance = balance.setScale(2, RoundingMode.UP);
				balance = balance.subtract(NICKEL_VALUE);
				nickelAmount++; 
			}
		}
		balance = new BigDecimal(0.00).setScale(2);
		String stringToLog = LocalDateTime.now().toString() +  " GIVE CHANGE: $" + totalChange + "  $" + balance;
		VMLogger.log(stringToLog);
		changePrinter(totalChange, quarterAmount, dimeAmount, nickelAmount);
		return balance;
	} 
	
	public void changePrinter(BigDecimal total, int quarters, int dimes, int nickels) {
		System.out.println("Your change is: $" + total + " | " + quarters +" Quarter(s) - " + dimes + " Dime(s) - " 
				+ nickels + " Nickel(s).");
	}
	
}