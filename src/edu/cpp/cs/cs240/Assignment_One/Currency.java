package edu.cpp.cs.cs240.Assignment_One;

public class Currency {
	
	/**
	 * This field represents the absolute value of the currency. Expressed in units, each type of currency should have a unique value.
	 */
	private int value;
	
	/**
	 * This field represents the name of the currency.  Each currency should have a name.
	 */
	private String name;
	
	/**
	 * The default value for the currency.
	 */
	private static int defaultValue = 1;
	
	/**
	 * The default name for the currency.
	 */
	private static String defaultName = "Penny";
	
	/**
	 * The default constructor for the currency.
	 */
	public Currency(){
		this(defaultValue, defaultName);
	}
	
	/**
	 * This constructor takes the name and value parameters and sets them as the respective fields.
	 * 
	 * @param value
	 * @param name
	 */
	public Currency(int value, String name){
		this.value = value;
		this.name = name;
	}
	
	/**
	 * This method returns the {@link #value} of the currency.
	 * 
	 * @return An integer representation of the {@link #value} of the currency.
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * This method modifies the {@link #value} of the currency.
	 * 
	 * @param value - An integer representation of the currency's value.
	 */
	public void setValue(int value){
		this.value = value;
	}
	
	/**
	 * This method returns the {@link #name} of the currency.
	 * 
	 * @return name - A String representation of the currency's name.
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * This method modifies the value of {@link #name} with the given parameter.
	 * 
	 * @param name - A string representation of the currency's name.
	 */
	public void setName(String name){
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "This is a " + this.getName() + " with a unit value of " + this.getValue() + ".";
	}
	
	

}
