package ece325_assignment2;

import java.io.BufferedReader;
import java.io.FileReader;

public class CollectionManager {
	SongCollection songs;
	Album album;
	
	public CollectionManager(String songsFile) {
		loadTxt(songsFile);
	}
	
	// Re-used code from ECE 325 Lab 2
	private void loadTxt(String file) {
		// Initialize the data we will return to a real array so our compiler won't complain.
		// Don't worry - later in the course we will look at better ways to do this. 
		// Create a new instance of album
		album = new Album();
		
		// We did not talk about exceptions yet but for now read the following part as follows:
		// If an error occurs during the execution of the code in the try block, the program will 
		// execute the code in the catch block, otherwise it will skip the catch block. 
		try {
			// Create a stream to read from the file
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			// The first line of the file contains an integer that represents the number of rows,
			// the rest of the file contains one word on every line
			int totalLines = Integer.parseInt(in.readLine());
			// Read the file and store it in the data that we will return
			while ((line = in.readLine()) != null) {
				// Each line is the name of a song, there may be duplicates
				Song song = new Song(line);
				// Add the song to the overall collection. We'll check for duplicates when making an album
				album.addSongToCollection(song);
			}
			// Only execute the following block if a problem occurred during reading the file
		} catch (Exception e) {
			// Print some details that should help you solve the problem.
			System.err.println("Problem while reading the data for file: " + file);
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		// CollectionManager collection = new CollectionManager("/Users/manjotsaggu/Documents/University_of_Alberta/ECE 325/Assignments/ece325_assignment2/songs.txt");
		CollectionManager collection = new CollectionManager("songs.txt");
		// We have out song collection but must put it through the parsing system we've created
		// in order to remove duplicates from the album listing we are trying to make
		String albumTrackList = collection.album.toString();
		System.out.println(albumTrackList);
	}
}
