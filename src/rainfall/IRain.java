package rainfall;

/*
 * Interface that manages the aspects of the rain 
 */
public interface IRain extends Comparable<IRain>
{ 
	 public double getRain(boolean getInches); 
	 
	 public int getYear();
	 
	 public String getMonthName(); 

	 public String getCountryName();
	
	 public String getCountryCode();
	 
	 //helper method
	 public int getMonthNumber(String monthName);
}