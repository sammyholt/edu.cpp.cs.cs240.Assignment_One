package edu.cpp.cs.cs240.Assignment_One;

import java.util.Scanner;
import java.util.Arrays;

public class UserInterface {
	
	public String welcomeMessage = "Welcome to the coin dispenser system!";
	
	private Dispenser dispenser;
	
	private Scanner keyboard = null;
	
	private String[] allowedInputs = {"$1", "$5", "$10", "$100", "$500", "PENNY", "NICKLE", "DIME", "QUARTER", "QUIT"};
	
	private Currency dollar = new Currency(100, "$1");
	private Currency fiveDollar = new Currency(500, "$5");
	private Currency tenDollar = new Currency(1000, "$10");
	private Currency hundredDollar = new Currency(10000, "$100");
	private Currency fiveHundredDollar = new Currency(50000, "$500");
	
	private Currency penny = new Currency(1, "Penny");
	private Currency nickle = new Currency(5, "Nickle");
	private Currency dime = new Currency(10, "Dime");
	private Currency quarter = new Currency(25, "Quarter");
	
	/**
	 * Default constructor.
	 */
	public UserInterface(){
		this(new Dispenser());
	}
	
	public UserInterface(Dispenser dispenser){
		this.dispenser = dispenser;
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * This loop will allow currency items to be entered into the dispenser until the user quits.
	 */
	public void enterCurrency(){
		String input = null;
		do{
			input = this.getNextChoice();
			switch(input){
				case "$1":
					dispenser.addCurrency(dollar);
					break;
				case "$5":
					dispenser.addCurrency(fiveDollar);
					break;
				case "$10":
					dispenser.addCurrency(tenDollar);
					break;
				case "$100":
					dispenser.addCurrency(hundredDollar);
					break;
				case "$500":
					dispenser.addCurrency(fiveHundredDollar);
					break;
				case "PENNY":
					dispenser.addCurrency(penny);
					break;
				case "NICKLE":
					dispenser.addCurrency(nickle);
					break;
				case "DIME":
					dispenser.addCurrency(dime);
					break;
				case "QUARTER":
					dispenser.addCurrency(quarter);
					break;
				default:
					break;
			}
		}while(!input.equals("QUIT"));
	}
	
	
	/**
	 * This method returns a String representation of the next input from the user.
	 * It will either represent the type of currency to add or a signal that
	 * they are done entering money.
	 * 
	 */
	public String getNextChoice(){
		String nextChoice = null;
		boolean valid = false;
		System.out.print("Enter a currency or quit. Valid inputs are $1, $5, $10, $100, $500, Penny, Nickle, Dime, Quarter, Quit: ");
		do{
			nextChoice = keyboard.next();
			if(contains(allowedInputs, nextChoice.toUpperCase())){
				valid = true;
			}
			
			if(!valid){
				System.out.print("Invalid choice! Try again: ");
			}
		}while(!valid);
		return nextChoice.toUpperCase();
	}
	
	private boolean contains(String[] array, String item){
		for(String a : array){
			if(a.equals(item)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * The main function of the program.  Everything will happen here.
	 */
	public void mainLoop(){
		System.out.println(welcomeMessage);
		this.enterCurrency();
		System.out.println(dispenser);
	}

}
