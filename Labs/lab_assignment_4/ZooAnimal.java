package ece325_lab_assignment4;

import java.time.LocalDate;

/**
 * Finish the implementation of this class. No need to add any instance variables or methods.
 *
 */
public class ZooAnimal {
	/**
	 * The last date on which this animal was fed.
	 */
	private LocalDate lastFeed;
	
	/**
	 * The name of the animal.
	 */
	private String name;
	
	public ZooAnimal(String name) {
		this.name = name;
	}
	
	public LocalDate getLastFeed() {
		return lastFeed;
	}
	
	
	/**
	 * Returns true iff the animal was fed already today.
	 * @return true if the animal was fed today
	 */
	public boolean isFedAlready() {
		// if the lastFeed date = the current feed attempt date
		return(LocalDate.now().equals(lastFeed));
	}
	
	public void feed() {
		// set lastFeed to today's date
		lastFeed = LocalDate.now();
		// State which animal was fed
		System.out.println(getName() + " was fed!");
	}
	
	public String getName() {
		return name;
	}
}
