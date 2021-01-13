package com.techelevator;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	
	private BigDecimal balance;
	private List<Vendable> vendableList;
	
	
	public VendingMachine() {
		super();
	}

	public VendingMachine(List<Vendable> list, BigDecimal balance) {
		
		this.vendableList = list;
		this.balance = balance;
	}
	public List<Vendable> getList() {
		return vendableList;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public static VendingMachine dispenseProduct(VendingMachine vm, String productId) throws FileNotFoundException {
		boolean productFound = false;
		String productSelection = productId;
		for (int i = 0; i < vm.vendableList.size(); i++) {
			if (vm.vendableList.get(i).getId().equals(productSelection)) {
				productFound = true;
				if (vm.vendableList.get(i).getQuantity() < 1) {
					System.out.println("SOLD OUT!");
				}
				else {
						if (vm.balance.compareTo(vm.vendableList.get(i).getPrice()) < 0) {
						System.out.println("Not enough funds.");
					}
					else {
						vm.balance = vm.balance.subtract(vm.vendableList.get(i).getPrice());
						System.out.println(vm.vendableList.get(i).getName() 
								+ " " + vm.vendableList.get(i).getPrice() + " " + vm.vendableList.get(i).getMessage());
						System.out.println("Current Money Provided: " + vm.balance);
						vm.vendableList.get(i).setQuantity(vm.vendableList.get(i).getQuantity() - 1);
						String stringToLog = LocalDateTime.now().toString() + " "
								+ vm.vendableList.get(i).getName() + " " + vm.vendableList.get(i).getId() + " $" 
								+ vm.vendableList.get(i).getPrice() + "  $" + vm.balance;
						VMLogger.log(stringToLog);
					}
				}
			} 
		}
			if (!productFound) {
				System.out.println("Invalid Entry");
			}
		return vm;
	}
	
}