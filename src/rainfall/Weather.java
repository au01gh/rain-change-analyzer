package rainfall;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.io.FileNotFoundException;

/*
 * Class that implements the methods of the IWeather interface
 */
public class Weather 
{
	private ArrayList<IRain> data;
	
	/*
	 * Constructs a Weather arrayList out of a rain object arrayList
	 */
	public Weather() 
	{
		data = new ArrayList<IRain>();
	}

	/* 
	 * Reads the data from the csv file and parses the lines into an arrayList
	 * @param fileName: the csv file that is inputed to be read 
	 * @return data: arrayList containing the lines of the parsed data 
	 */
	 public ArrayList<IRain> readData(String fileName)
	 {
		 //handles possible errors when scanning the given file
		 try
		 {
			 File inputFile = new File(fileName);
			 Scanner scan = new Scanner(inputFile);
			 
			 //instantiation of variables
			 String line;
			 Rain temp;
			 
			 //reads the first line so the while loop can start at the next line
			 scan.nextLine();
			 
			 //while there is a line to be read until the end of the file
			 while(scan.hasNextLine()) 
			 {
				 line = scan.nextLine();
				 //splits a given line into an array at each comma
				 String [] lineSplit = line.split(",");
				 
				 //the line is separated into arrays 
				 double rainfall = Double.parseDouble(lineSplit[0].trim());
				 int year = Integer.parseInt(lineSplit[1].trim());
				 String month =  lineSplit[2].trim();
				 String country = lineSplit[3].trim();
				 String countryCode = lineSplit[4].trim();
				 
				 //creates and adds the arrays as a rain object to the arrayList
				 temp = new Rain(rainfall, year, month, country, countryCode);
				 data.add(temp);
			 }
			 scan.close();
		 } 
		 catch (FileNotFoundException exception)
		 {
			exception.printStackTrace();
		 }
		 return data;
	 }
	 
	 /*
	  * Writes the header of the csv file for each method call in the RainChange class
	  * @param filename: the filename that the subject is being written to 
	  * @param subject: the description of the task for the csv file 
	  */
	 public void writeHeader(String filename, String subject) 
	 {
		try 
		{
			//writes the header to the file
			FileWriter write = new FileWriter(filename, true);
			//the description of each task
			write.write(subject + "\n");
	        write.close();
		} 
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
	 }
	 
	 /*
	  * Writes the rain data for a given method to a specific task file
	  * @param filename: the new filename that the data is written to
	  * @param text: the specific method's task id
	  * @param rainData: the arrayList from the read data
	  */
	 public void writeData(String filename, String text, ArrayList<IRain> rainData) 
	 {
		try 
		{
			//instantiation of the data written to the file
			String writeDataToFile = " ";
			
			//creates a new file and a new fileWriter
			File name = new File(filename);
			//appends the file which allows the program to write to it again if needed
			FileWriter write = new FileWriter(name, true);

			//the header consisting of various values
			String header = "Rainfall, Year, Month, Country, Country Code";
			write.write(header + "\n");
			
			//if the file is empty, a message will be displayed
			write.write(text);
			
			//iteration of all rain objects in the read data arrayList
			for(IRain rainObj : rainData) 
			{
				//the rainfall in millimeters and inches 
				double mmRainfall = rainObj.getRain(false);
				double inRainfall = rainObj.getRain(true);
				
				//formats the rainfall to two decimal places
			    DecimalFormat df = new DecimalFormat("#.##"); 
			    String mm = df.format(mmRainfall);
				String in = df.format(inRainfall);		
				String getRainfall = mm + "(mm) " + in + "(in)";	
				
				//gets the other variables to write to the file
				writeDataToFile =  getRainfall + ", " + rainObj.getYear() + ", " + rainObj.getMonthName() + ", " + rainObj.getCountryName() + ", " + rainObj.getCountryCode(); 
				write.write(writeDataToFile + "\n");
			}
	        write.close();
		} 
		catch (IOException exception)
		{
			exception.printStackTrace();
		}
	 }
}