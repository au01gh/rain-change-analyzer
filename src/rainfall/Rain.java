package rainfall;

import java.util.TreeMap;

/*
 * Class that implements the methods of the IRain interface
 */
public class Rain implements IRain
{
	private double rain;
	private int year;
	private String monthName;
	private String countryName;
	private String countryCode;
	
	 /*
	  * Constructor creates the rain object that consists of the rainfall, year, month, country, and country code
	  * @param rain: rain in millimeters or in inches
	  * @param year: year of the rainfall 
	  * @param month: month of the rainfall
	  * @param country: name of the country
	  * @param countryCode: 3-letter code of the country
	  */
	 public Rain(double rain, int year, String monthName, String countryName, String countryCode) 
	 {
		this.rain = rain;
		this.year = year;
		this.monthName = monthName;
		this.countryName = countryName;
		this.countryCode = countryCode;
	}

	 /*
	  * Gets the rainfall
	  * @param getInches: if inches should or should not be used for the rainfall 
	  * @return inches: rainfall in inches 
	  * @return rain: rainfall in millimeters 
	  */
	 public double getRain(boolean getInches) 
	 {
		 if(getInches) 
		 {
			 double inches = rain * (1.0 / 25.4);
			 return inches;
		 }
		 else 
		 {
			 return rain;
		 }
	 }
	 
	 /*
	  * Gets the year
	  * @return year: year of the rainfall 
	  */
	 public int getYear() 
	 {
		 return year;
	 }
	 
	 /*
	  * Gets the name of the month
	  * @return monthName: name of the month 
	  */
	 public String getMonthName() 
	 {
		 return monthName;
	 }
	 
	 /*
	  * Gets the name of the country
	  * @return countryName: name of the country
	  */
	 public String getCountryName() 
	 {
		 return countryName;
	 }
	 
	 /*
	  * Gets the 3-letter code of the country
	  * @return countryCode: 3-letter code of the country
	  */
	 public String getCountryCode() 
	 {
		 return countryCode;
	 }	 
	
	 /*
	  * Prints the rain objects in a string format
	  * @return the rain objects in a string format
	  */
	 public String toString() 
	 {
		 return rain + " " + year + " " + monthName + " " + countryName + " " + countryCode + "\n";
	 }
	 
	 /*
	  * Converts the name of the month to a number
	  * @param monthName: name of the month
	  * @return monthNumber: the associated number with a month
	  */
	 public final int getMonthNumber(String monthName) 
	 {
		TreeMap<String, Integer> months  = new TreeMap<String, Integer>(); 

	     months.put("Jan", 1); 
	     months.put("Feb", 2); 
	     months.put("Mar", 3); 
	     months.put("Apr", 4); 
	     months.put("May", 5); 
	     months.put("Jun", 6); 
	     months.put("Jul", 7); 
	     months.put("Aug", 8); 
	     months.put("Sep", 9); 
	     months.put("Oct", 10); 
	     months.put("Nov", 11); 
	     months.put("Dec", 12); 
	     
	     //gets the number value 
		 int monthNumber = months.get(monthName);
		 return monthNumber;
	 } 
    
    /*
     * Compares the rain object by rainfall, country, year, then month
     * @param that: the other rain object 
     * @return the comparison between two instances of the variables
     */
    public int compareTo(IRain that) 
	{
    	//rainfall only compared in millimeters
		if(this.rain != that.getRain(false)) 
		{
			return (int)Math.signum(this.rain - that.getRain(false)); //double
		}
		else if(!this.countryName.contentEquals(that.getCountryName()))
		{
			return this.countryName.compareTo(that.getCountryName()); //string
		}
		else if(this.year != that.getYear()) 
		{
			return this.year - that.getYear(); //int
		}
		else 
		{
			return getMonthNumber(this.getMonthName()) - getMonthNumber(that.getMonthName()); //int
		}
	}
    
    /*
     * Checks if two rain objects are the same
     * @param x: which is an object that the rain is compared to 
     * @return true if the rain objects are the same, false otherwise
     */
    public boolean equals(Object x)
    {   
    	IRain that = (IRain) x;   
    	return this.compareTo(that) == 0;  
    }
}