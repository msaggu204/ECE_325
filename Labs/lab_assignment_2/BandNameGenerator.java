import java.io.BufferedReader;
import java.io.FileReader;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;

	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;

	String adjectivesFile;
	String nounsFile;
	
	
	int adjectivesLength;
	int nounsLength;

	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		loadAdjectives();
		loadNouns();
	}

	public void loadAdjectives() {
		adjectives = loadTxt("/Users/manjotsaggu/Documents/University_of_Alberta/ECE 325/Lab 2/BandNameGenerator/adjectives.txt");
		// Find the length of the array adjectives
		adjectivesLength = adjectives.length;
		// Adjectives have been loaded, so change Boolean to true.
		// Further error catching is taken care of in the loadTxt method.
		adjectivesLoaded = true;
	}

	public void loadNouns() {
		nouns = loadTxt("/Users/manjotsaggu/Documents/University_of_Alberta/ECE 325/Lab 2/BandNameGenerator/nouns.txt");
		// Find the length of the array nouns
		nounsLength = nouns.length;
		// Nouns have been loaded, so change Boolean to true
		nounsLoaded = true;
	}

	/**
	 * Randomly generates and returns a band name that consists of an adjective followed by a noun.
	 * Returns "UNINITIALIZED" if the adjectives or nouns were not (correctly) loaded. 
	 * @return The generated band name
	 */
	public String generate() {
		String bandName;
		// Returns "UNINITIALIZED" if nouns and adjectives are not loaded
		if(nounsLoaded && adjectivesLoaded == false) {
			bandName = "UNINITIALIZED";
		}
		else {
			// Generate a random number to pick a noun and adjective
			int adjNum = (int) (Math.random()*(adjectivesLength));
			int nounNum = (int) (Math.random()*(nounsLength));
			// Join the bandName based on the array index for each part of the name required.
			bandName = adjectives[adjNum] + " " + nouns[nounNum];
		}
		return bandName;
	}
	
	/**
	 * We have not discussed I/O (reading/writing files) yet, so you can use this
	 * function to load the adjectives and nouns text files.
	 * 
	 * @param file: a String that contains the name of the file you want to read. 
	 * @return
	 */
	private String[] loadTxt(String file) {
		// Initialize the data we will return to a real array so our compiler won't complain.
		// Don't worry - later in the course we will look at better ways to do this. 
		String[] data = new String[0];
		
		// We did not talk about exceptions yet but for now read the following part as follows:
		// If an error occurs during the execution of the code in the try block, the program will 
		// execute the code in the catch block, otherwise it will skip the catch block. 
		try {
			// Create a stream to read from the file
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			// The first line of the file contains an integer that represents the number of rows,
			// the rest of the file contains one word on every line
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			// Read the file and store it in the data that we will return
			while ((line = in.readLine()) != null) {
				data[i] = line;
				i++;

			}
			// Only execute the following block if a problem occurred during reading the file
		} catch (Exception e) {
			// Print some details that should help you solve the problem.
			System.err.println("Problem while reading the data for file: " + file);
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Run the program and randomly generate 20 (no more, no less) band names every time you execute it.
	 * The names may be different across runs. 
	 * @param args
	 */
	public static void main(String[] args) {
		BandNameGenerator name = new BandNameGenerator("adjectives.txt", "nouns.txt");
		String bandName = name.generate();
		System.out.println(bandName);
	}

}
