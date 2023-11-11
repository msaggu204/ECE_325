package ece325_lab_assignment6;

import java.io.*;

public class CompareManySmallStringsConcatenation {
	/**
	 * Creates numberOfStrings String objects and performs operationsPerString concatenation
	 * operations on every string. Note that you can create one string first, then perform all
	 * the operations on that string, then create the second string, etc.
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private static void concatString(int numberOfStrings, int concatOperationsPerString) {
		for(int i = 0; i < numberOfStrings; i++) {
			// Instantiate  empty string 
			@SuppressWarnings("unused")
			String string = "";
			for(int j = 0; j < concatOperationsPerString; j++) {
				// Concatenate using + operator
				string += "test";
			}
		}
	}

	/**
	 * Creates numberOfStrings StringBuilder objects and performs operationsPerString concatenation
	 * operations on every StringBuilder. Note that you can create one StringBuilder first, then 
	 * perform all the operations on that StringBuilder, then convert the StringBuilder to a String, 
	 * then create the second StringBuilder, etc.
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private static void concatStringBuilder(int numberOfStrings, int concatOperationsPerString) {
		for(int i = 0; i < numberOfStrings; i++) {
			// Instantiate new StringBuilder for each string
			StringBuilder strBuilder = new StringBuilder();
			for(int j = 0; j < concatOperationsPerString; j++) {
				// Concatenate using StringBuilder
				strBuilder.append("test");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int numberOfStrings[] = {1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000} ;
		int numberOfOperations[] = {0, 1, 2, 3, 4};
		
		MillisPerformanceMeasurement performance = new MillisPerformanceMeasurement();
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter("CompareSmall.csv");
        // Insert headers: A1 = Approach 1 (String), A2 = Approach 2 (StringBuilder), ops = # of concatenation operations
        outputfile.append("# of strings");
        outputfile.append(",");
        outputfile.append("A1 (ops: 0)");
        outputfile.append(",");
        outputfile.append("A2 (ops: 0)");
        outputfile.append(",");
        outputfile.append("A1 (ops: 1)");
        outputfile.append(",");
        outputfile.append("A2 (ops: 1)");
        outputfile.append(",");
        outputfile.append("A1 (ops: 2)");
        outputfile.append(",");
        outputfile.append("A2 (ops: 2)");
        outputfile.append(",");
        outputfile.append("A1 (ops: 3)");
        outputfile.append(",");
        outputfile.append("A2 (ops: 3)");
        outputfile.append(",");
        outputfile.append("A1 (ops: 4)");
        outputfile.append(",");
        outputfile.append("A2 (ops: 4)");
        outputfile.append("\n");
        
		for(int i : numberOfStrings) {
			System.out.println("# of strings: " + i);
			outputfile.append(Integer.toString(i));
			for(int j : numberOfOperations) {
				System.out.println("# of operations: " + j);
				outputfile.append(",");
				// Approach 1 (String):
				// Using the + operator on two strings:
				performance.start();
				concatString(i, j);
				performance.end();
				// Get the performance timing for + operator
				long time1 = performance.getResult();
				
				outputfile.append(Long.toString(time1));
				outputfile.append(",");
				// Approach 2 (StringBuilder):
				// Using a StringBuilder object.
				performance.start();
				concatStringBuilder(i, j);
				performance.end();
				// Get the performance timing or StringBuilder
				long time2 = performance.getResult();
				
				System.out.println("");
				outputfile.append(Long.toString(time2));
			}
			outputfile.append("\n");
		}
		// flush and close the FileWriter
		outputfile.flush();
		outputfile.close();
	}
}