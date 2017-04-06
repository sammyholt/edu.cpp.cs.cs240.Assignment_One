package edu.cpp.cs.cs240.Assignment_One;

import java.util.ArrayList;

/**
 * The Dispenser is the main class of the program.  The dispenser holds all the 
 * currency objects and has methods for manipulating the data it holds.  It can also
 * display that data.
 * 
 * @author Samuel Holt
 *
 */
public class Dispenser {
	
	/**
	 * The number of quarters in the dispenser.  It should be modified whenever a coin is added.
	 */
	private int numberQuarters;
	
	/**
	 * The number of dimes in the dispenser.  It should be modified whenever a coin is added.
	 */
	private int numberDimes;
	
	/**
	 * The number of nickles in the dispenser.  It should be modified whenever a coin is added.
	 */
	private int numberNickles;
	
	/**
	 * The number of pennies in the dispenser.  It should be modified whenever a coin is added.
	 */
	private int numberPennies;
	
	/**
	 * The main currency storage.  This ArrayList stores all the currency items in the dispenser.
	 */
	ArrayList<Currency> billsAndCoins;
	
	/**
	 * The default constructor.
	 */
	public Dispenser(){
		this(new ArrayList<Currency>());
	}
	
	/**
	 * The constructor takes an ArrayList of Currency objects as a parameter.
	 */
	public Dispenser(ArrayList<Currency> billsAndCoins){
		this.numberQuarters = 0;
		this.numberDimes = 0;
		this.numberNickles = 0;
		this.numberPennies = 0;
		this.billsAndCoins = billsAndCoins;
		this.updateCoins();
	}
	
	/**
	 * Add a currency item to the dispenser.
	 * 
	 * @param c - A currency object
	 */
	public void addCurrency(Currency c){
		this.billsAndCoins.add(c);
		this.updateCoins();
	}
	
	/**
	 * This method updates the amount of coins of each type which can represent the total value
	 * inside the dispenser. It should be called any time a dispenser is created or a currency item is added to
	 * the dispenser.
	 * 
	 * @param value - Total unit value inside the dispenser
	 */
	public void updateCoins(){
		// Penny = 1, Nickle = 5, Dime = 10, Quarter = 25
		int tempValue = this.getTotalValue();
		this.numberQuarters = 0;
		this.numberDimes = 0;
		this.numberNickles = 0;
		this.numberPennies = 0;
		while(tempValue > 0){
			if(tempValue >= 25){
				tempValue -= 25;
				this.numberQuarters += 1;
			}else if(tempValue >= 10){
				tempValue -= 10;
				this.numberDimes += 1;
			}else if(tempValue >= 5){
				tempValue -= 5;
				this.numberNickles += 1;
			}else{
				tempValue -= 1;
				this.numberPennies += 1;
			}
		}
	}
	
	/**
	 * This method returns the total value of all the currency held in the dispenser.  It loops
	 * through each currency object inside the {@link #billsAndCoins} Currency ArrayList and calls the 
	 * getValue() method from the Currency class.
	 * 
	 * @return Total unit value inside the dispenser.
	 */
	public int getTotalValue(){
		int totalValue = 0;
		for(Currency c : billsAndCoins){
			totalValue += c.getValue();
		}
		return totalValue;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/**
	 * This method takes the absolute value of all currency in the dispenser and converts
	 * that value into a string of coins.
	 * 
	 * @return A string representation of coins from largest to smallest value.
	 */
	@Override
	public String toString() {
		return "This dispenser has " + this.numberQuarters + " Quarters, " + this.numberDimes + " Dimes, " + this.numberNickles + " Nickles,"
				+ " and " + this.numberPennies + " Pennies.";
	}
	
	

}
