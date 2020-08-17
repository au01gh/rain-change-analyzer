package rainfall;

import java.util.ArrayList;

/*
 * Interface that manages the aspects of the weather
 */
public interface IWeather 
{
	public ArrayList<IRain> readData(String fileName);
	 
	public void writeHeader(String fileName, String subject);
	 
	public void writeData(String fileName, String text, ArrayList<IRain> rainData);
}