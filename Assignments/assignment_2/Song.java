package ece325_assignment2;

public class Song {
	String title;
	
	public Song(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		// Just for the sake of the toString method in SongCollection - we need the song title
		return title;
	}
	
	public boolean equals(Object o) {
		// If all contents of strings are the same, equals returns true
		// otherwise, returns false
		String track;
		// Cast the object passed as a type of song and retrieve the title
		track = ((Song)o).title;
		// Compare through the equals method if the two tracks are the same
		// equals() returns boolean value
		return this.title.equals(track);
	}
}