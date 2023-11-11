package ece325_lab_assignment5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * This class represents a Song. A Song has a title, release date, and a popularity score.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class SongCollection {
	// not allowed to change anything after this until the indicated line
	private TreeSet<Song> collection;
	
	public SongCollection() {
		collection = new TreeSet<Song>();
	}
	
	public static LocalDate parseLocalDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(str, formatter);
	}
	
	public void addSong(Song s) {
		collection.add(s);
	}	
	
	public String toString() {
		String str = "[SongCollection: " + collection.size() + " songs: \n";
		for(Song s : collection) {
			str += "\t" + s + "\n";
		}
		return str + "]";
	}
	
	// you are allowed to make changes/add code after this
	
	public void loadSongs(String filename) throws IOException {
		// Must substantiate null for each buffered reader and scanner
		BufferedReader in = null;
		Scanner s = null;
		// Purely for error handling for the user - line counter
		int l = 1;
		// Try to find the file with filename
		try {
			// Instantiate new bufferedreader to read lines from the file
			in = new BufferedReader(new FileReader(filename));  
			String line;
			// As long as lines are not empty...
			while((line = in.readLine()) != null) {
				// Instantiate new scanner to parse each line
				s = new Scanner(line);
				// Remove commas between characters
				s.useDelimiter(",");
				// Purely for error testing
				l++;
				// Initialize variables of a song
				String track;
				int popularity;
				LocalDate releaseDate;
				// while the next string is not empty...
				while(s.hasNext()) {
					try {
						// the title is first, then popularity, then releaseDate
						track = s.next();
						popularity = Integer.parseInt(s.next());
						releaseDate = parseLocalDate(s.next());
						// Add a new instance of a song
						// had to add "implements Comparable<Song>" to the Song class
						Song song = new Song(track, releaseDate, popularity);
						addSong(song);
					} 
					// For garbage/corrupted lines
					catch (Exception e) {
						// We could use this but a more detailed approach is nice to have
						// e.printStackTrace();
						// Using the line number, we can let the user know which lines are garbage
						String lineNum = String.valueOf(l);
						String garbage = "Line #" + lineNum + " from the file is garbage or may be corrupted!";
						System.out.println(garbage);
					}
				}
			}
		}
		// General error catching for no file found
		catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		// Clean up! Close bufferedReader
		finally {
			if(in != null) {
				in.close();
			}
			// Clean up! Close scanner
			if(s != null) {
				s.close();
			}
		}
	}
	
	// Sometimes we want to compare the songs based on popularity
	public List<Song> sort(Comparator<Song> comp) {
		// Instantiate new TreeSet to be used for the popularity-based sort
		TreeSet<Song> sorted = new TreeSet<Song>(comp);
		for(Song song:collection) {
			sorted.add(song);
		}
		// We require this list to be returned in the form of a list and not a TreeList
		List<Song> popSort = new ArrayList<Song>(sorted);
		return popSort;
	}
	
	
	public static void main(String[] args) throws IOException {
		// load and print the songs here
		SongCollection collection = new SongCollection();
		collection.loadSongs("songs.txt");
		// Using toString() of the SongCollection class
		System.out.println(collection);
		// Instantiating new comparator for popularity
		SongComparator comparator = new SongComparator();
		List<Song> popSort = collection.sort(comparator);
		// We don't have toString() to use so print each song manually
		for(Song song:popSort) {
			System.out.println(song);
		}
	}
}
