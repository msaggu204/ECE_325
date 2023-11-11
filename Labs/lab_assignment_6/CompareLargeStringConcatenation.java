package ece325_lab_assignment6;

import java.io.*;

public class CompareLargeStringConcatenation {
	/**
	 * Creates a String object, performs concatOperations operations on it and returns the resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the String.
	 * @return The resulting String.
	 */
	private static String concatString(int concatOperations) {
		// Instantiate  empty string 
		String string = "";
		// Concatenate using + operator
		for(int i = 0; i < concatOperations; i++) {
			string += "test";
		}
		return string;
	}
	
	/**
	 * Creates a StringBuilder object, performs concatOperations operations on it, converts the StringBuilder to a String and returns the 
	 * resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the StringBuilder.
	 * @return The resulting String.
	 */
	private static String concatStringBuilder(int concatOperations) {
		// Instantiate new StringBuilder
		StringBuilder strBuilder = new StringBuilder(); 
		// Concatenate using StringBuilder
		for(int i = 0; i < concatOperations; i++) {
			strBuilder.append("test");
		}
		String result = strBuilder.toString();
		return result;
	}

	public static void main(String[] args) throws IOException {
		// perform your experiments here
		MillisPerformanceMeasurement performance = new MillisPerformanceMeasurement();
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter("CompareLarge.csv");
        // insert column headers
        outputfile.append("# of concatenation operations");
        outputfile.append(",");
        outputfile.append("Approach 1 (String)");
        outputfile.append(",");
        outputfile.append("Approach 2 (StringBuilder)");
        outputfile.append("\n");
        
		for (int numberOfStrings = 10; numberOfStrings <= 100000; numberOfStrings *= 10) {
			System.out.println("# of concatenation operations: " + numberOfStrings);
			outputfile.append(Integer.toString(numberOfStrings));
			outputfile.append(",");
			// Approach 1 (String):
			// Using the + operator on two strings:
			performance.start();
			concatString(numberOfStrings);
			performance.end();
			// Get performance timing for + operator
			long time1 = performance.getResult();
			
			outputfile.append(Long.toString(time1));
			outputfile.append(",");
			// Approach 2 (StringBuilder):
			// Using a StringBuilder object.
			performance.start();
			concatStringBuilder(numberOfStrings);
			performance.end();
			// Get performance timing for StringBuilder
			long time2 = performance.getResult();
			
			System.out.println("");
			outputfile.append(Long.toString(time2));
			outputfile.append("\n");
		}
		// Flush and close the FileWriter
		outputfile.flush();
		outputfile.close();
	}
}
