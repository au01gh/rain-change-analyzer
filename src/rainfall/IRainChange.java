package rainfall;

import java.util.TreeSet;
import java.util.ArrayList;

/*
 * Interface that manages the aspects of the rainfall
 */
public interface IRainChange 
{
	//1
	public IRain getLowestMonthlyRainfall(String countryName, int monthNumber);
	 
	public IRain getHighestMonthlyRainfall(String countryName, int monthNumber); 
	
	//2
	public IRain getLowestYearlyRainfall(String countryName, int year);
	
	public IRain getHighestYearlyRainfall(String countryName, int year);
	
	//3
	public TreeSet<IRain> getRainfallInRangeForCountry(String countryName, double lowRainfall, double highRainfall);
	
	//4
	public IRain getLowestRainfallForCountry(String countryName);
	 
	public IRain getHighestRainfallForCountry(String countryName);
	
	//5
	public ArrayList<IRain> get10LowestRainfallForMonth(int monthNumber);
	
	public ArrayList<IRain> get10HighestRainfallForMonth(int monthNumber);
	
	//6 
	public ArrayList<IRain> get10LowestRainfall();
	 
	public ArrayList<IRain> get10HighestRainfall();
	
	//7 
	public ArrayList<IRain> getRainfallInRange(double lowRainfall, double highRainfall);
	
	//8 
	public ArrayList<IRain> get10GreatestRainfallChange(int monthNumber, int year1, int year2); 
	 
	public IRain getGreatestRainfallChange(int year1, int year2); 
	 
	public void executeRainChange();
}