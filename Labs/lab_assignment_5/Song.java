package ece325_lab_assignment5;

import java.time.LocalDate;

/**
 * This class represents a Song. A Song has a title, release date, and a popularity score.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class Song implements Comparable<Song> { // you are allowed to change this line, if necessary
	// not allowed to change anything after this until the indicated line
	private String title;
	private LocalDate releaseDate;
	private int popularity;

	public Song(String title, LocalDate releaseDate, int popularity) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.popularity = popularity;
	}

	public String getTitle() {
		return this.title;
	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public int getPopularity() {
		return this.popularity;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public void setPopularity(int p) {
		if(popularity > 0)
			popularity = p;
	}
	
	public String toString() {
		return "[Song: " + title + ", released on " + releaseDate + ", popularity: " + popularity + "]";
	}
	
	// allowed to change/add after this
	// TreeSet orders the songs alphabetically by title and then from new to old.
	public int compareTo(Song s) {
		String track = s.getTitle();
		LocalDate sDate = s.getReleaseDate();
		
		// result is a negative integer if this String object lexicographically precedes the argument string
		if(title.compareTo(track) < 0) {
			return -1;
		}
		// positive integer if this String object lexicographically precedes the argument string
		else if(title.compareTo(track) > 0) {
			return 1;
		}
		else {
			sDate = s.getReleaseDate();
			// Release date is before the song release date - return -1
			// Release date is after the song release date - return 1
			// Two songs are considered duplicates if they have the same title and release date - return 0
			return (releaseDate.isBefore(sDate) ? -1 : (releaseDate.isAfter(sDate) ? 0 : 1));
		}
	}
}
