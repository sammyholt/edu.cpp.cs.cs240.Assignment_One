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
		this.addToDispenser();
		System.out.println(dispenser);
	}
	
	/**
	 * This method will allow the user to enter currency as many times as they
	 * want until they enter -1 to quit entering currency.  The method will
	 * add new currency objects to the dispenser based on the input from the user.
	 */
	private void addToDispenser(){
		boolean quit = false;
		
		do{
			double enteredAmount = this.getNextAmount();
			if(enteredAmount == -1){
				quit = true;
			}else{
				double value = enteredAmount * 100;
				dispenser.addCurrency(new Currency((int)value, "Custom Amount"));
			}
		}while(!quit);
	}
	
	/**
	 * This method asks the user to input an amount of currency in "Dollars and Cents" format.  For example,
	 * Twelve dollars and thirty cents should be entered as "12.30".  The method will also validate that the input is in 
	 * the correct format and will reject any input which is not in the expected format.
	 * 
	 * @return An amount of currency in the traditional "Dollars and Cents" format.
	 */
	private double getNextAmount(){
		double nextAmount = 0.0;
		boolean invalid = true;
		
		do{
			System.out.print("Enter an amount (ex: 12.15) or enter -1 to quit: ");
			try{
				nextAmount = Double.parseDouble(keyboard.next());
				invalid = false;
			}catch(NumberFormatException e){
				System.out.println("Invalid input format! Expected format is in standard \"Dollars and Cents\" format (eg 12.15).");
			}
			
		}while(invalid);
		return nextAmount;
	}
}
