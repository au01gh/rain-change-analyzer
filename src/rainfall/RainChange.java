package rainfall;

import java.util.Scanner;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NavigableSet;

/*
 * Class that implements the methods of the IRainChange interface
 */
public class RainChange implements IRainChange
{
	//repetitive data
	private ArrayList<IRain> rainData;
	//specific data sets
	private ArrayList<String> countryNames;
	private HashSet<String> countries;
	//arrayLists
	private ArrayList<IRain> tenLowestRainfall;
	private ArrayList<IRain> tenHighestRainfall;
	private ArrayList<IRain> sortedLowestRainfall;
	private ArrayList<IRain> sortedHighestRainfall;
	//treeSets 
	private TreeSet<IRain> lowestRainfall;
	private TreeSet<IRain> highestRainfall;
	private TreeSet<IRain> rainfallRange;
	
	/*
	 * Runs the RainChange method to obtain user input
	 */
	public static void main(String[] args)
	{
		RainChange output = new RainChange();
		output.executeRainChange();
	}
	
	/*
	 * Constructs a RainChange arrayList out of a rain object arrayList
	 */
	public RainChange()
	{
	  //reads the data from the csv file
	  Weather weather = new Weather();
	  rainData = weather.readData("data/world_rainfall_1991-2016.csv");
	  
	  //storage from the read data is created
	  countries = new HashSet<String>();
	  
		for(IRain rainObj: rainData) 
		{
			//countries stored 
			String country = rainObj.getCountryName().toLowerCase();
			countries.add(country);
		}
	}
	
	/*
	 * For all data that matches the specified month, the lowest rainfall reading is outputted
	 * @param countryName: the specified country for the rainfall
	 * @param monthName: the specified month for the rainfall
	 * @return lowestRainfallObj: the object that has the lowest rainfall
	 */
	 public IRain getLowestMonthlyRainfall(String countryName, int monthNumber)
	 {
		//empty set
		lowestRainfall = new TreeSet<IRain>();

		for(IRain rainObj : rainData) 
		{
			//checks if the country and month match those of any rain objects
			if(countryName.equalsIgnoreCase(rainObj.getCountryName()) && monthNumber == rainObj.getMonthNumber(rainObj.getMonthName()))
			{
				lowestRainfall.add(rainObj);
			}
		}
		//returns the first element in the ordered set
		IRain lowestRainfallObj = lowestRainfall.first();
		return lowestRainfallObj;
	 }
		
	 /*
	  * For all data that matches the specified month, the highest rainfall reading is outputted
	  * @param countryName: the specified country for the rainfall
	  * @param monthNumber: the specified month for the rainfall
	  * @return highestRainfallObj: the object that has the highest rainfall
	  */
	 public IRain getHighestMonthlyRainfall(String countryName, int monthNumber) 
	 {
		//empty set
		highestRainfall = new TreeSet<IRain>();

		for(IRain rainObj : rainData) 
		{
			//checks if the country and month match those of any rain objects
			if(countryName.equalsIgnoreCase(rainObj.getCountryName()) && monthNumber == rainObj.getMonthNumber(rainObj.getMonthName()))
			{
				highestRainfall.add(rainObj);
			}
		}
		//returns the last element in the ordered set
		IRain highestRainfallObj = highestRainfall.last();
		return highestRainfallObj;
	 } 
	 
	 /*
	  * For all data that matches the specified year, the lowest rainfall reading is outputted
	  * @param countryName: the specified country for the rainfall
	  * @param year: the specified year for the rainfall
	  * @return lowestRainfallObj: the object that has the lowest rainfall
	  */
	 public IRain getLowestYearlyRainfall(String countryName, int year) 
	 {
		 //empty set
		 lowestRainfall = new TreeSet<IRain>();

		 for(IRain rainObj : rainData) 
		 {
			//checks if the country and year match those of any rain objects
			 if(countryName.equalsIgnoreCase(rainObj.getCountryName()) && year == rainObj.getYear())
			 {
				 lowestRainfall.add(rainObj);
			 }
		 }
		//returns the first element in the ordered set
		 IRain lowestRainfallObj = lowestRainfall.first();
		 return lowestRainfallObj;
	 }

	 /*
	  * For all data that matches the specified year, the highest rainfall reading is outputted
	  * @param countryName: the specified country for the rainfall
	  * @param year: the specified year for the rainfall
	  * @return highestRainfallObj: the object that has the highest rainfall
	  */
	 public IRain getHighestYearlyRainfall(String countryName, int year)
	 {
		//empty set
		highestRainfall = new TreeSet <IRain>();

		for(IRain rainObj : rainData) 
		{
			//checks if the country and year match those of any rain objects
			if(countryName.equalsIgnoreCase(rainObj.getCountryName()) && year == rainObj.getYear())
			{
				highestRainfall.add(rainObj);
			}
		}
		//returns the last element in the ordered set
		IRain highestRainfallObj = highestRainfall.last();
		return highestRainfallObj;
	}
	 
	 /*
	  * Gets all rain data that fall within the given rain range
	  * @param countryName: the specified country for the rain
	  * @param rangeLowTemp: the specified low bound for the rain
	  * @param rangeHighTemp: the specified high bound for the rain
	  * @return rainfallRange: a treeSet of objects that are between the range
	  */
	 public TreeSet<IRain> getRainfallInRangeForCountry(String countryName, double lowRainfall, double highRainfall)
	 {
		 //empty set
		 rainfallRange = new TreeSet<IRain>();
		
		 for(IRain rainObj : rainData) 
		 {
			//checks if the country match those of any rain object
			 if(countryName.equalsIgnoreCase(rainObj.getCountryName()))
		     {
				//checks if the rain object is in between the range
		    	 if(lowRainfall <= rainObj.getRain(false) && rainObj.getRain(false) <= highRainfall) 
		    	 {
		    		 rainfallRange.add(rainObj);
		    	 }
			 }
		 }
		 //returns the rain range in a set
		 return rainfallRange;
	 }
	
	 /*
	  * Gets the lowest rainfall reading amongst all data for that country
	  * @param countryName: the specified country for the rainfall
	  * @return lowestRainfallObj: the object that has the lowest rainfall
	  */
	 public IRain getLowestRainfallForCountry(String countryName) 
	 {
		 //empty set
		 lowestRainfall = new TreeSet<IRain>();

		 for(IRain rainObj : rainData) 
		 {
			//checks if the country matches those of any rain object
			 if(countryName.equalsIgnoreCase(rainObj.getCountryName()))
			 {
				 lowestRainfall.add(rainObj);
			 }
		 }
		 //returns the first element in the ordered set
		 IRain lowestRainfallObj = lowestRainfall.first();
		 return lowestRainfallObj;
	 }
	 
	 /*
	  * Gets the highest rainfall reading amongst all data for that country
	  * @param countryName: the specified country for the rainfall
	  * @return highestRainfallObj: the object that has the highest rainfall
	  */
	 public IRain getHighestRainfallForCountry(String countryName)
	 {
		 //empty set
		 highestRainfall = new TreeSet<IRain>();
		 
		 for(IRain rainObj : rainData) 
		 {
			//checks if the country matches those of any rain object
			 if(countryName.equalsIgnoreCase(rainObj.getCountryName()))
			 {
				 highestRainfall.add(rainObj);
			 }
		 }
		 //returns the last element in the ordered set
		 IRain highestRainfallObj = highestRainfall.last();
		 return highestRainfallObj;
	 }
	 
	 /*
	  * Eliminates duplicate countries when finding the lowest rainfall
	  * @param tenRain: the empty arrayList 
	  * @param sortedRain: the sorted arrayList without duplicate countries
	  * @param countryNames: the names of all the countries
	  */
	 public void lowNoDuplicates(ArrayList<IRain> tenRain, ArrayList<IRain> sortedRain, ArrayList<String> countryNames) 
	 {
		//starts at the beginning
		int setSize = 0;
		//checks if the size of the sorted list is less than ten each iteration
		while (sortedRain.size() < 10) 
		{
			//if the country is in tenTemp
			boolean containsCountry = countryNames.contains(tenRain.get(setSize).getCountryName());
			if (!containsCountry) 
			{
				//adds to both lists
				countryNames.add(tenRain.get(setSize).getCountryName());
				sortedRain.add(tenRain.get(setSize));
			}
			//increments forward
			setSize = setSize + 1;
		}
	}
	 
	 /*
	  * Eliminates duplicate countries when finding the highest rainfall
	  * @param tenRain: the empty arrayList 
	  * @param sortedRain: the sorted arrayList without duplicate countries
	  * @param countryNames: the names of all the countries
	  */
	 public void highNoDuplicates(ArrayList<IRain> tenRain, ArrayList<IRain> sortedRain, ArrayList<String> countryNames) 
	 {
		//starts at the end 
		int setSize = tenRain.size() - 1;
		//checks if the size of the sorted list is less than ten each iteration
		while (sortedRain.size() < 10)
		{
			//if the country is in tenTemp
			boolean containsCountry = countryNames.contains(tenRain.get(setSize).getCountryName());
			if (!containsCountry)
			{
				//checks if the size of the sorted list is less than ten each iteration
				countryNames.add(tenRain.get(setSize).getCountryName());
				sortedRain.add(tenRain.get(setSize));
			}
			//increments backwards
			setSize = setSize - 1;
		}
	 }
	 
	 /*
	  * Returns the top ten lowest rainfalls for a specified month
	  * @param monthNumber: the specified month for the rainfalls
	  * @return sortedLowestTemp: the sorted lowest ten rainfalls
	  */
	 public ArrayList<IRain> get10LowestRainfallForMonth(int monthNumber)
	 {
		//empty lists
		tenLowestRainfall = new ArrayList<IRain>();
		sortedLowestRainfall = new ArrayList<IRain>();
		countryNames = new ArrayList<String>();

		for(IRain rainObj : rainData) 
		{
			//checks if month matches those of any rain objects
			if(monthNumber == rainObj.getMonthNumber(rainObj.getMonthName())) 
			{
				tenLowestRainfall.add(rainObj);
			}
		}
		//sorts the list in order
		Collections.sort(tenLowestRainfall);
	
		lowNoDuplicates(tenLowestRainfall, sortedLowestRainfall, countryNames);
	
		return sortedLowestRainfall;
	 }
	 
	 /*
	  * Returns the top ten highest rainfalls for a specified month
	  * @param monthNumber: the specified month for the rainfalls
	  * @return sortedHighestTemp: the sorted highest ten rainfalls
	  */
	 public ArrayList<IRain> get10HighestRainfallForMonth(int monthNumber)
	 {
		//empty lists
	    tenHighestRainfall = new ArrayList<IRain>();
		sortedHighestRainfall = new ArrayList<IRain>();
		countryNames = new ArrayList<String>();

		for(IRain rainObj: rainData) 
		{
			//checks if month matches those of any rain objects
			if(monthNumber == rainObj.getMonthNumber(rainObj.getMonthName())) 
			{
				tenHighestRainfall.add(rainObj);
			}
		}
		//sorts the list in order
		Collections.sort(tenHighestRainfall);
		
		highNoDuplicates(tenHighestRainfall, sortedHighestRainfall, countryNames);
		//reverses the list
		Collections.reverse(sortedHighestRainfall);
		 
		return sortedHighestRainfall;	
	 }

	 /*
	  * Returns the top ten lowest rainfalls
	  * @return sortedLowestTemp: the sorted lowest ten rainfalls
	  */
	 public ArrayList<IRain> get10LowestRainfall()
	 {
		//empty lists
		tenLowestRainfall = new ArrayList<IRain>();
		sortedLowestRainfall = new ArrayList<IRain>();
		countryNames = new ArrayList<String>();

		for(IRain rainObj : rainData) 
		{
			tenLowestRainfall.add(rainObj);	
		}
		//sorts the list in order
		Collections.sort(tenLowestRainfall);
			
		lowNoDuplicates(tenLowestRainfall, sortedLowestRainfall, countryNames);
		
		return sortedLowestRainfall;
	 }
	 
	 /*
	  * Returns the top ten highest rainfalls
	  * @return sortedHighestTemp: the sorted highest ten rainfalls
	  */
	 public ArrayList<IRain> get10HighestRainfall()
	 {
		//empty lists
		tenHighestRainfall = new ArrayList<IRain>();
		sortedHighestRainfall = new ArrayList<IRain>();
		countryNames = new ArrayList <String>();

		for(IRain rainObj : rainData) 
		{				
			tenHighestRainfall.add(rainObj);
		}
		//sorts the list in order
		Collections.sort(tenHighestRainfall);
			
		highNoDuplicates(tenHighestRainfall, sortedHighestRainfall, countryNames);
		//reverses the list
		Collections.reverse(sortedHighestRainfall);
			
		return sortedHighestRainfall;
	 }

	 /*
	  * Gets all rain data that falls within the given range
	  * @param lowRainfall: the specified low bound for the rain
	  * @param highRangeTemp: the specified high bound for the rain
	  * @return lowRainfall: an arrayList of objects that are between the range
	  */
	 public ArrayList<IRain> getRainfallInRange(double lowRainfall, double highRainfall)
	 {
		 //empty set
		 rainfallRange = new TreeSet<IRain>();
			
		 for(IRain rainObj : rainData) 
		 {
			 //checks if the rain object is in between the range
	    	 if(lowRainfall <= rainObj.getRain(false) && rainObj.getRain(false) <= lowRainfall) 
	    	 {
	    		 rainfallRange.add(rainObj);
	    	 }
		 } 
		 //returns the objects in the rain range in a list
		 ArrayList<IRain> sortedTempRange = new ArrayList<IRain>(rainfallRange);
		 return sortedTempRange;
	 }
	 
	 /*
	  * Gets the countries with the largest rain difference of the same month between 2 given years
	  * @param monthNumber: the specified month for the rain
	  * @param year1: the given year for the rain
	  * @param year2: the given year for the rain
	  */
	 public ArrayList<IRain> get10GreatestRainfallChange(int monthNumber, int year1, int year2)
	 {
		 //empty set and list
		 TreeSet<IRain> deltaChange = new TreeSet<IRain>();
		 ArrayList<IRain> tenDelta = new ArrayList<IRain>();
		 //lists if year and month match for each input
		 ArrayList<IRain> rainObj1 = new ArrayList<IRain>();
		 ArrayList<IRain> rainObj2 = new ArrayList<IRain>();
		 
	 	 for(IRain rainObj : rainData) 
		 {
	 		 //checks if the month and year1 match those of any rain objects
	    	 if(monthNumber == rainObj.getMonthNumber(rainObj.getMonthName()) && rainObj.getYear() == year1) 
			 {
				 rainObj1.add(rainObj);
			 }
	    	 //checks if the month and year2 match those of any rain objects
	    	 if(monthNumber == rainObj.getMonthNumber(rainObj.getMonthName()) && rainObj.getYear() == year2) 
	    	 {
	    		 rainObj2.add(rainObj);
	    	 }
		 }
	 	 //sorts the data from highest to lowest delta values
	 	 for(int element = 0; element < rainObj1.size(); element++) 
	 	 {
	 		//gets the rains of year1 and year2 objects
	 		double rain1 = rainObj1.get(element).getRain(false);
	 		double rain2 = rainObj2.get(element).getRain(false);
	 		//delta values of rainfall and year difference
	 		double rainDelta = Math.abs(rain1 - rain2);
		    int yearDelta = Math.abs(year1 - year2);
		    //rate of change in rains between those years
		    double rate = rainDelta/yearDelta;
			//the other information for the rain object
			String monthName = rainObj1.get(element).getMonthName();
			String country = rainObj1.get(element).getCountryName();
			String countryCode = rainObj1.get(element).getCountryCode();
			//creates and adds the arrays as a rain object to the arrayList
			Rain deltaObj = new Rain(rate, yearDelta, monthName, country, countryCode);
			deltaChange.add(deltaObj);
	 	 }
	 	 //sorts the data from highest to lowest delta values
	 	 NavigableSet<IRain> sortDelta = deltaChange.descendingSet(); 
		 ArrayList<IRain> sortDeltaList = new ArrayList<IRain>(sortDelta);
		
		 //gets the first 10 highest delta values and reverses the set
		 for(int element = 0; element < 10; element++) 
		 {
			tenDelta.add(sortDeltaList.get(element));
		 }
		 Collections.reverse(tenDelta);
		 return tenDelta;
	 }	
	 
	 /*
	  * Gets the country with the largest rain difference between 2 given years
	  * @param year1: the given year for the rain
	  * @param year2: the given year for the rain
	  */
	 public IRain getGreatestRainfallChange(int year1, int year2)
	 {
		 //empty set
		 TreeSet<IRain> deltaChange = new TreeSet<IRain>();
		 //lists if year and month match for each input
		 ArrayList<IRain> rainObj1 = new ArrayList<IRain>();
		 ArrayList<IRain> rainObj2 = new ArrayList<IRain>();
		 for(IRain rainObj : rainData) 
		 {
			 //checks if the year1 matches that of any rain objects
			 if(year1 == rainObj.getYear()) 
			 {
				 rainObj1.add(rainObj);
			 }
			 //checks if the year2 matches that of any rain objects
			 if(year2 == rainObj.getYear()) 
			 {
				 rainObj2.add(rainObj);
			 }
		 }
		 //sorts the data from highest to lowest delta values
		 for(int element = 0; element < rainObj1.size(); element++) 
	 	 {
	 		//gets the rains of year1 and year2 objects
	 		double rain1 = rainObj1.get(element).getRain(false);
	 		double rain2 = rainObj2.get(element).getRain(false);
	 		//delta values of rainfall and year difference
	 		double rainDelta = Math.abs(rain1 - rain2);
		    int yearDelta = Math.abs(year1 - year2);
		    //rate of change in rains between those years
		    double rate = rainDelta/yearDelta;
			//the other information for the rain object
			String monthName = rainObj1.get(element).getMonthName();
			String country = rainObj1.get(element).getCountryName();
			String countryCode = rainObj1.get(element).getCountryCode();
			//creates and adds the arrays as a rain object to the arrayList
			Rain deltaObj = new Rain(rate, yearDelta, monthName, country, countryCode);
			deltaChange.add(deltaObj);
	 	 }
		 return deltaChange.last();
	 }
	 
	 /*
	  * Runs all the methods with user input and validation
	  */
	 public void executeRainChange() 
	 {
		 //scans the file and creates objects
		 Scanner scan = new Scanner(System.in);
		 Weather weather = new Weather();
		 RainChange rain = new RainChange();
		 
		 //1.1---------------------------------------------------------------------------------------------------------------------------------------------------------------
		 System.out.println("1.1: Gets the lowest rainfall by month for a country");
		 
			 System.out.println("Enter a country name:");
			 String a11countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a11countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a11countryName = scan.nextLine();
			 }
			 
				 System.out.println("Enter a numeric month value:");
				 
				 int a11monthValue = 0;
				 //executes if the month value is outside of the range
				 while(a11monthValue < 1 || a11monthValue > 12) 
				 {
					 //try-catch block handles the exception with a prompt
					 try 
					 {
						 //the input is the month value
						 a11monthValue = Integer.parseInt(scan.nextLine());
						 if(a11monthValue < 1 || a11monthValue > 12) 
						 {
							 System.out.println("Enter a numeric month value:");
						 }
					 }
					 catch(NumberFormatException exception) 
					 {
						 System.out.println("Enter a numeric month value:");
					 }
				 }
				 
			//object is added to a new arrayList and written to a file
			ArrayList<IRain> a11 = new ArrayList<IRain>();
			a11.add(rain.getLowestMonthlyRainfall(a11countryName, a11monthValue));
		    weather.writeHeader("A1_data.csv", "Gets the lowest rainfall by month #" + a11monthValue + " for " + a11countryName);
		    weather.writeData("A1_data.csv", "", a11);
			 
			
		//1.2----------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("1.2: Gets the highest rainfall by month for a country");
			 
			 System.out.println("Enter a country name:");
			 String a12countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a12countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a12countryName = scan.nextLine().toLowerCase();
			 }
				 
				 System.out.println("Enter a numeric month value:");
				 int a12monthValue = 0;
				 //executes if the month value is outside of the range
				 while(a12monthValue < 1 || a12monthValue > 12) 
				 {
					 //try-catch block handles the exception with a prompt
					 try 
					 {
						 //the input is the month value
						 a12monthValue = Integer.parseInt(scan.nextLine());
						 if(a12monthValue < 1 || a12monthValue > 12) 
						 {
							 System.out.println("Enter a numeric month value:");
						 }
					 }
					 catch(NumberFormatException exception) 
					 {
						 System.out.println("Enter a numeric month value:");
					 }
				 }
				 
			//object is added to a new arrayList and written to a file
			ArrayList<IRain> a12 = new ArrayList<IRain>();
			a12.add(rain.getHighestMonthlyRainfall(a12countryName, a12monthValue));
			weather.writeHeader("A1_data.csv", "Gets the highest rainfall by month #" + a12monthValue + " for " + a12countryName);
			weather.writeData("A1_data.csv", "", a12);
			
			
		//2.1----------------------------------------------------------------------------------------------------------------------------------------------------------------
		 System.out.println("2.1: Gets the lowest rainfall by year for a country");
		 
			 System.out.println("Enter a country name:");
			 String a21countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a21countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a21countryName = scan.nextLine();
			 }
			 
				 System.out.println("Enter a numeric year value (1991-2016):");
				 
				 int a21yearValue = 0;
				 //executes if the year value is outside of the range
				 while(a21yearValue < 1991 || a21yearValue > 2016) 
				 {
					 //try-catch block handles the exception with a prompt 
					 try 
					 {
						 //the input is the year value
						 a21yearValue = Integer.parseInt(scan.nextLine());
						 if(a21yearValue < 1991 || a21yearValue > 2016) 
						 {
							 System.out.println("Enter a numeric year value (1991-2016):");
						 }
					 }
					 catch(NumberFormatException exception) 
					 {
						 System.out.println("Enter a numeric year value (1991-2016):");
					 }
				 }
				 
			//object is added to a new arrayList and written to a file
			ArrayList<IRain> a21 = new ArrayList<IRain>();
			a21.add(rain.getLowestYearlyRainfall(a21countryName, a21yearValue));
		    weather.writeHeader("A2_data.csv", "Gets the lowest rainfall by " + a21yearValue + " for " + a21countryName);
			weather.writeData("A2_data.csv", "", a21);
				 
				
		//2.2----------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("2.2: Gets the highest rainfall by year for a country");
			 
			 System.out.println("Enter a country name:");
			 String a22countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a22countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a22countryName = scan.nextLine().toLowerCase();
			 }
				 
				 System.out.println("Enter a numeric year value (1991-2016):");
				 int a22yearValue = 0;
				 //executes if the year value is outside of the range
				 while(a22yearValue < 1991 || a22yearValue > 2016)
				 {
					 //try-catch block handles the exception with a prompt 
					 try 
					 {
						//the input is the year value
						a22yearValue = Integer.parseInt(scan.nextLine());
						if(a22yearValue < 1991 || a22yearValue > 2016) 
						 {
							 System.out.println("Enter a numeric year value (1991-2016):");
						 }
					 }
					 catch(NumberFormatException exception) 
					 {
						 System.out.println("Enter a numeric year value (1991-2016):");
					 }
				 }
				 
			//object is added to a new arrayList and written to a file
			ArrayList<IRain> a22 = new ArrayList<IRain>();
			a22.add(rain.getHighestYearlyRainfall(a22countryName, a22yearValue));
			weather.writeHeader("A2_data.csv", "Gets the highest rainfall by " + a22yearValue + " for " + a22countryName);
			weather.writeData("A2_data.csv", "", a22);	
		
			
		 //3.1---------------------------------------------------------------------------------------------------------------------------------------------------------------
		 System.out.println("3.1: Gets the rainfall in the specified range for a country");
		 
			 System.out.println("Enter a country name:");
			 String a3countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a3countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a3countryName = scan.nextLine();
			 }
			 
				 System.out.println("Enter the lower bound of rainfall (mm):");
				 //Prompts again if the rain input is invalid
				 while(!scan.hasNextDouble()) 
				 {
					 System.out.println("Enter the lower bound of rainfall (mm):");
					 scan.next();
				 }
				 double lowerRain1 = scan.nextDouble();
				 
					 System.out.println("Enter the higher bound of rainfall (mm):");
					 //Prompts again if the rain input is invalid
					 while(!scan.hasNextDouble()) 
					 {
						 System.out.println("Enter the higher bound rainfall (mm):");
						 scan.next();
					 }
					 double higherRain1 = scan.nextDouble();
					 
			//object is added to a new arrayList and written to a file
			ArrayList<IRain> a3 = new ArrayList<IRain>(rain.getRainfallInRangeForCountry(a3countryName, lowerRain1, higherRain1));
		    weather.writeHeader("A3_data.csv", "Gets the rainfall from " + lowerRain1 + "(mm) to " + higherRain1 + "(mm) for " + a3countryName);
		    //check if list is empty
		    if (a3.isEmpty()) 
		    {
		    	weather.writeData("A3_data.csv", "No data is present with the given information", a3);
		    }
		    else 
		    {
		    	weather.writeData("A3_data.csv", "", a3);
		    }
		 
			
		//4.1----------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("4.1: Gets the lowest rainfall for a country");
		
			 scan.nextLine();
			 System.out.println("Enter a country name:");
			 String a41countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a41countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a41countryName = scan.nextLine().toLowerCase();
			 }
			//object is added to a new arrayList and written to a file		 	
			ArrayList<IRain> a41 = new ArrayList<IRain>();
			a41.add(rain.getLowestRainfallForCountry(a41countryName));
			weather.writeHeader("A4_data.csv", "Gets the lowest rainfall for " + a41countryName);
			weather.writeData("A4_data.csv", "", a41);	
	 
		
		//4.2----------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("4.2: Gets the highest rainfall for a country");
			 
			 System.out.println("Enter a country name:");
			 String a42countryName = scan.nextLine().toLowerCase();
			 //keeps running until country is found
			 while(!countries.contains(a42countryName)) //compares the input with the countries hashSet
			 {
				 System.out.println("Enter a country name:");
				 a42countryName = scan.nextLine().toLowerCase();
			 }
			//object is added to a new arrayList and written to a file	 
			ArrayList<IRain> a42 = new ArrayList<IRain>();
			a42.add(rain.getHighestRainfallForCountry(a42countryName));
			weather.writeHeader("A4_data.csv", "Gets the highest rainfall for " + a42countryName);
			weather.writeData("A4_data.csv", "", a42);	
	
			
		//5.1---------------------------------------------------------------------------------------------------------------------------------------------------------------- 
		System.out.println("5.1: Gets the top 10 lowest rainfalls for a month");
		
			 System.out.println("Enter a numeric month value:");
			 
			 int b11monthValue = 0;
			 //executes if the month value is outside of the range
			 while(b11monthValue < 1 || b11monthValue > 12) 
			 {
				 //try-catch block handles the exception with a prompt
				 try 
				 {
					 //the input is the month value
					 b11monthValue = Integer.parseInt(scan.nextLine());
					 if(b11monthValue < 1 || b11monthValue > 12) 
					 {
						 System.out.println("Enter a numeric month value:");
					 }
				 }
				 catch(NumberFormatException exception) 
				 {
					 System.out.println("Enter a numeric month value:");
				 }
			 }
			 //arrayList of objects is written to a file
			 weather.writeHeader("B1_data.csv", "Gets the 10 lowest rainfalls by month #" + b11monthValue);
			 weather.writeData("B1_data.csv", "", rain.get10LowestRainfallForMonth(b11monthValue));
		
		
		//5.2---------------------------------------------------------------------------------------------------------------------------------------------------------------- 
		System.out.println("5.2: Gets the top 10 highest rainfalls for a month");
				
			 System.out.println("Enter a numeric month value:");
			 
			 int b12monthValue = 0;
			 //executes if the month value is outside of the range
			 while(b12monthValue < 1 || b12monthValue > 12) 
			 {
				 //try-catch block handles the exception with a prompt
				 try 
				 {
					 //the input is the month value
					 b12monthValue = Integer.parseInt(scan.nextLine());
					 if(b12monthValue < 1 || b12monthValue > 12) 
					 {
						 System.out.println("Enter a numeric month value:");
					 }
				 }
				 catch(NumberFormatException exception) 
				 {
					 System.out.println("Enter a numeric month value:");
					 }
				 }
			 
			 //arrayList of objects is written to a file
			 weather.writeHeader("B1_data.csv", "Gets the 10 highest rainfalls by month #" + b12monthValue);
			 weather.writeData("B1_data.csv", "", rain.get10HighestRainfallForMonth(b12monthValue));
		
	        
	      //6.1-------------------------------------------------------------------------------------------------------------------------------------------------------------- 
		  System.out.println("6.1: Gets the top 10 lowest rainfalls");
		  
			  //arrayList of objects is written to a file
			  weather.writeHeader("B2_data.csv", "Gets the 10 lowest rainalls");
			  weather.writeData("B2_data.csv", "", rain.get10LowestRainfall());
			
		  
		  //6.2-------------------------------------------------------------------------------------------------------------------------------------------------------------- 
		  System.out.println("6.2: Gets the top 10 highest rainfalls");
		  
			  //arrayList of objects is written to a file
			  weather.writeHeader("B2_data.csv", "Gets the 10 highest rainfalls");
			  weather.writeData("B2_data.csv", "", rain.get10HighestRainfall());
		  
		  
		  //7.1-------------------------------------------------------------------------------------------------------------------------------------------------------------- 				
		  System.out.println("7.1: Gets the rainfall in the specified range");
			
		  		System.out.println("Enter the lower bound of rainfall (mm):");
		  	 //Prompts again if the rain input is invalid
			 while(!scan.hasNextDouble()) 
			 {
				 System.out.println("Enter the lower bound of rainfall (mm):");
				 scan.next();
			 }
			 double lowerRain2 = scan.nextDouble();
			 
				 System.out.println("Enter the higher bound of rainfall (mm):");
				     //Prompts again if the rain input is invalid
					 while(!scan.hasNextDouble()) 
					 {
						 System.out.println("Enter the higher bound of rainfall (mm):");
						 scan.next();
					 }
					 double higherRain2 = scan.nextDouble();
		    //arrayList of objects is written to a file
		    weather.writeHeader("B3_data.csv", "Gets the rains from " + lowerRain2 + "(mm) to " + higherRain2 + "(mm)");
		    //check if list is empty
		    ArrayList <IRain> test = rain.getRainfallInRange(lowerRain2, higherRain2);
			if (test.isEmpty()) 
			{
				weather.writeData("B3_data.csv", "No data is present with the given information", test);
			}
			else 
			{
				weather.writeData("B3_data.csv", "", test);
			}
		  
		  
		  //8.1-------------------------------------------------------------------------------------------------------------------------------------------------------------- 				
		  System.out.println("8.1: Gets the largest rainfall differences of the same month between the given years");
		  
			System.out.println("Enter a numeric month value:");
			scan.nextLine();
			 
			int c1monthValue = 0;
			//executes if the month value is outside of the range
			while(c1monthValue < 1 || c1monthValue > 12) 
			{
			    //try-catch block handles the exception with a prompt
				try 
				{
					//the input is the month value
					c1monthValue = Integer.parseInt(scan.nextLine());
					if(c1monthValue < 1 || c1monthValue > 12) 
					{
						System.out.println("Enter a numeric month value:");
					}
				}
				catch(NumberFormatException exception) 
				{
					System.out.println("Enter a numeric month value:");
				}
			}
			 
				System.out.println("Enter a numeric year1 value (1991-2016):");
				 
				int c1year1 = 0;
				//executes if the year value is outside of the range
				while(c1year1 < 1991 || c1year1 > 2016)
				{
					//try-catch block handles the exception with a prompt
					try 
					{
						//the input is the year value
						c1year1 = Integer.parseInt(scan.nextLine());
						if(c1year1 < 1991 || c1year1 > 2016) 
						 {
							 System.out.println("Enter a numeric year1 value (1991-2016):");
						 }
					 }
					 catch(NumberFormatException exception) 
					 {
						 System.out.println("Enter a numeric year1 value (1991-2016):");
					 }
				}
				 
					System.out.println("Enter a numeric year2 value (1991-2016):");
					 
					 int c1year2 = 0;
					 //executes if the year value is outside of the range
					 while(c1year2 < 1991 || c1year2 > 2016)
					 {
						 //try-catch block handles the exception with a prompt
						 try 
						 {
							//the input is the year value
							c1year2 = Integer.parseInt(scan.nextLine());
							if(c1year2 < 1991 || c1year2 > 2016) 
							{
								System.out.println("Enter a numeric year2 value (1991-2016):");
							}
						 }
						 catch(NumberFormatException exception) 
						 {
							 System.out.println("Enter a numeric year2 value (1991-2016):");
						 }
					}
			//arrayList of objects is written to a file
			weather.writeHeader("C1_data.csv", "Gets the largest rain differences of month #" + c1monthValue + " between " + c1year1 + " and " + c1year2);
			weather.writeData("C1_data.csv", "", rain.get10GreatestRainfallChange(c1monthValue, c1year1, c1year2));	
						
		//8.2----------------------------------------------------------------------------------------------------------------------------------------------------------------
		System.out.println("8.2: Gets the greatest change in rainfall between the given years");
		 
		System.out.println("Enter a numeric year1 value (1991-2016):");
		 
			int c2year1 = 0;
			//executes if the year value is outside of the range
			while(c2year1 < 1991 || c2year1 > 2016)
			{
				//try-catch block handles the exception with a prompt
				try 
				{
					//the input is the year value
					c2year1 = Integer.parseInt(scan.nextLine());
					if(c2year1 < 1991 || c2year1 > 2016) 
					 {
						System.out.println("Enter a numeric year1 value (1991-2016):");
					 }
				 }
				 catch(NumberFormatException exception) 
				 {
					 System.out.println("Enter a numeric year1 value (1991-2016):");
				 }
			}
			 
				System.out.println("Enter a numeric year2 value (1991-2016):");
				 
				int c2year2 = 0;
				//executes if the year value is outside of the range
				while((c2year2 < 1991 || c2year2 > 2016))
				{
					//try-catch block handles the exception with a prompt
					try 
					{
						//the input is the year value
						c2year2 = Integer.parseInt(scan.nextLine());
						if(c2year2 < 1991 || c2year2 > 2016) 
						{
							System.out.println("Enter a numeric year2 value (1991-2016):");
						}
					}
					catch(NumberFormatException exception) 
					{
						System.out.println("Enter a numeric year2 value (1991-2016):");
					}
				}
			 
			//object is added to a new arrayList and written to a file
			ArrayList<IRain> c2 = new ArrayList<IRain>();
			c2.add(rain.getGreatestRainfallChange(c2year1, c2year2));
			weather.writeHeader("C1_data.csv", "Gets the greatest change in rain between " + c2year1 + " and " + c2year2);
			weather.writeData("C1_data.csv", "", c2);
		
		//close scanner
		scan.close();
		//end of user input
		System.out.println("Check the csv files created to access the data");		
	 }
}