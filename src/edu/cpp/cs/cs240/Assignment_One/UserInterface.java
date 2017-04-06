package edu.cpp.cs.cs240.Assignment_One;

import java.util.Scanner;

/**
 * The UserInterface class deals with all user interaction and controls the flow of the program. The user interface has a
 * single Dispenser for the user to interact with.
 * 
 * 
 * @author Samuel Holt
 *
 */
public class UserInterface {
	
	/**
	 * The string which should display at the beginning of the program.
	 */
	private String welcomeMessage = "CS 240: Coin dispenser by Samuel Holt";
	
	/**
	 * This is the main Dispenser of the program.
	 */
	private Dispenser dispenser;
	
	/**
	 * This scanner takes input from the user.
	 */
	private Scanner keyboard = null;
	
	/**
	 * This array holds all the valid options for input.
	 */
	private String[] allowedInputs = {"$1", "$5", "$10", "$100", "$500", "PENNY", "NICKLE", "DIME", "QUARTER", "QUIT"};
	
	/**
	 * All the possible "bill" currencies.
	 */
	private Currency dollar = new Currency(100, "$1");
	private Currency fiveDollar = new Currency(500, "$5");
	private Currency tenDollar = new Currency(1000, "$10");
	private Currency hundredDollar = new Currency(10000, "$100");
	private Currency fiveHundredDollar = new Currency(50000, "$500");
	
	/**
	 * All the possible "coin" currencies.
	 */
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
	
	/**
	 * The constructor which takes an optional dispenser object as a parameter.
	 * 
	 * @param dispenser
	 */
	public UserInterface(Dispenser dispenser){
		this.dispenser = dispenser;
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * The main function of the program.  Everything will start here.
	 */
	public void mainLoop(){
		System.out.println(welcomeMessage);
		this.enterCurrency();
		System.out.println(dispenser);
	}
	
	/**
	 * This loop will allow currency items to be entered into the dispenser until the user quits.
	 */
	private void enterCurrency(){
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
	 * The method will also check that the user input is a valid choice.
	 * 
	 */
	private String getNextChoice(){
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
	
	/**
	 * This method determines if a string is inside a string array.
	 * 
	 * @param array - An array of strings
	 * @param item - A string to look for
	 * @return True if the string is found.  False if the string is not found.
	 */
	private boolean contains(String[] array, String item){
		for(String a : array){
			if(a.equals(item)){
				return true;
			}
		}
		return false;
	}

}
