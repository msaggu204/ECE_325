package ece325_assignment2;

// Child class of SongCollection
// We will override methods as necessary to create an album 
public class Album extends SongCollection {
	
	@Override //annotation indicates that the child class method
	// is over-writing its base class method.
	public void addSongToCollection(Song s) {
		// Cannot have duplicate songs in the album
		if(this.contains(s) == false) {
			super.addSongToCollection(s);
		}
	}
	
	@Override
	// We don't need the extra brackets and string text that toString in
	// SongCollection super class. We just need the tracks, and then ouput
	// them how we would like to but we still need to get the tracklist first
	public String toString() {
		// Access the tracks in the album and remove any brackets and new line characters
		String tracks = super.toString();
		tracks = tracks.replace("[", "");
		tracks = tracks.replace("]", "");
		tracks = tracks.replace("\n", " ");
		
		String [] albumTracks = tracks.split("\t");
		String trackList = "";
		for (int i = 1; i < albumTracks.length; i++) {
			trackList += "Track #" + i + ": " + albumTracks[i] + "\n";
		}
		return trackList;
	}
}