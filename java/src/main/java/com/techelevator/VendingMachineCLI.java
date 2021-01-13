package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.view.Menu;
import com.techelevator.Vendable;

public class VendingMachineCLI extends Money{

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };
	
	private static final String FEED_MONEY_MENU_OPTION_ADD1 = "Add $1.00";
	private static final String FEED_MONEY_MENU_OPTION_ADD2 = "Add $2.00";
	private static final String FEED_MONEY_MENU_OPTION_ADD5 = "Add $5.00";
	private static final String FEED_MONEY_MENU_OPTION_ADD10 = "Add $10.00";
	private static final String FEED_MONEY_MENU_OPTION_EXIT = "Exit";
	private static final String[] FEED_MONEY_MENU_OPTIONS = { FEED_MONEY_MENU_OPTION_ADD1, FEED_MONEY_MENU_OPTION_ADD2, FEED_MONEY_MENU_OPTION_ADD5, FEED_MONEY_MENU_OPTION_ADD10, FEED_MONEY_MENU_OPTION_EXIT};
	
	private static final BigDecimal ONE_DOLLAR = new BigDecimal(1.00).setScale(2);
	private static final BigDecimal TWO_DOLLAR = new BigDecimal(2.00).setScale(2); 
	private static final BigDecimal FIVE_DOLLAR = new BigDecimal(5.00).setScale(2);
	private static final BigDecimal TEN_DOLLAR = new BigDecimal(10.00).setScale(2);
	
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() throws IOException {
		List<Vendable> vendingItems = new ArrayList<>();
		File newFile = new File("vendingmachine.csv");
		vendingItems = Vendable.buildVendableList(newFile);
		BigDecimal machineBalance = new BigDecimal(0.00).setScale(2, RoundingMode.UP);
		VendingMachine vend = new VendingMachine();
		Scanner scanner = new Scanner(System.in);
					
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(Vendable.renderVendables(vendingItems));
			} 
			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				boolean inSubMenu = true;
				
				while(inSubMenu) { 
					String subMenuChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					
					if (subMenuChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
						
						String moneyMenuChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
						
						if (moneyMenuChoice.equals(FEED_MONEY_MENU_OPTION_ADD1)) {
							machineBalance = feedMoney(machineBalance, ONE_DOLLAR);
							System.out.println("Your balance is: $" + machineBalance);
						} 
						else if (moneyMenuChoice.equals(FEED_MONEY_MENU_OPTION_ADD2)) {
							machineBalance = feedMoney(machineBalance, TWO_DOLLAR);
							System.out.println("Your balance is: $" + machineBalance);
						} 
						else if (moneyMenuChoice.equals(FEED_MONEY_MENU_OPTION_ADD5)) {
							machineBalance = feedMoney(machineBalance, FIVE_DOLLAR);
							System.out.println("Your balance is: $" + machineBalance); 
						} 
						else if (moneyMenuChoice.equals(FEED_MONEY_MENU_OPTION_ADD10)) {
							machineBalance = feedMoney(machineBalance, TEN_DOLLAR);
							System.out.println("Your balance is: $" + machineBalance);
						} 
						else if (moneyMenuChoice.equals(FEED_MONEY_MENU_OPTION_EXIT)) {
							System.out.println("Current balance is: $" + machineBalance);
						}
					} 
					else if (subMenuChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
						System.out.println(Vendable.renderVendables(vendingItems));
						System.out.println("Please choose."); 
						vend = new VendingMachine(vendingItems, machineBalance);
						String productToFind = scanner.nextLine();
						vend = VendingMachine.dispenseProduct(vend, productToFind);
						machineBalance = vend.getBalance();
						vendingItems = vend.getList();
					} 
					else if (subMenuChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
						machineBalance = changeGiven(machineBalance);
						inSubMenu = false;
					}
				} 
			} 
			else if (choice.contentEquals(MAIN_MENU_OPTION_EXIT)) {
				scanner.close();
				System.out.println("Program Terminated.");
				System.exit(1); // bye ill miss you
			}
		}
	} 

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}