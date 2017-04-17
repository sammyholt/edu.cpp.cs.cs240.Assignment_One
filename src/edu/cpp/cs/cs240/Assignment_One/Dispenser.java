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
	 * This array holds the number of pennies, nickels, dimes, and quarters contained in the dispenser.
	 * It should be updated whenever a coin is added.
	 * 
	 * Index 0: Quarters
	 * Index 1: Dimes
	 * Index 2: Nickels
	 * Index 3: Pennies
	 */
	private int[] coinArray = new int[4];
	
	/**
	 * The main currency storage.  This ArrayList stores all the currency items in the dispenser.
	 */
	private ArrayList<Currency> billsAndCoins;
	
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
		this.coinArray[0] = 0;
		this.coinArray[1] = 0;
		this.coinArray[2] = 0;
		this.coinArray[3] = 0;
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
		this.coinArray[0] = 0;
		this.coinArray[1] = 0;
		this.coinArray[2] = 0;
		this.coinArray[3] = 0;
		while(tempValue > 0){
			if(tempValue >= 25){
				tempValue -= 25;
				this.coinArray[0] += 1;
			}else if(tempValue >= 10){
				tempValue -= 10;
				this.coinArray[1] += 1;
			}else if(tempValue >= 5){
				tempValue -= 5;
				this.coinArray[2] += 1;
			}else{
				tempValue -= 1;
				this.coinArray[3] += 1;
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
		return "This dispenser has " + this.coinArray[0] + " Quarters, " + this.coinArray[1] + " Dimes, " + this.coinArray[2] + " Nickles,"
				+ " and " + this.coinArray[3] + " Pennies.";
	}
	
	

}
