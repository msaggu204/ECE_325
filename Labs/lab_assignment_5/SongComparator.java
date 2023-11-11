package ece325_lab_assignment5;

import java.util.Comparator;

// finish this
public class SongComparator implements Comparator<Song> {
	public int compare (Song s1, Song s2) {
		return Integer.valueOf(s1.getPopularity()).compareTo(Integer.valueOf(s2.getPopularity()));
	}
}
