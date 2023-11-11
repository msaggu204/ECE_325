package ece325_lab_assignment4;

/**
 * The artist/band that is performing. You must finish this class.
 * @author corpaul
 *
 */
public class Artist implements ZooPerformer {
	/** 
	 * Indicates whether the artist is currently playing (= performing). 
	 */
	private boolean isPlaying;
	
	public Artist() {
		isPlaying = false;
	}
	
	/** 
	 * Feed the animal. Make sure to check whether we are allowed to feed this animal,
	 * and make sure to handle things correctly if we are not allowed to feed it. You are allowed
	 * to change this method's signature, if necessary.
	 * 
	 */
	public void feed(ZooAnimal animal) throws AlreadyFedException, NotPlayingException {
		//		
		// did we already feed this animal today?
		if(animal.isFedAlready()) {
			throw new AlreadyFedException(animal.getName() + " was already fed today!");
		}
		// is the artist already playing?
		else if(!isPlaying) {
			throw new NotPlayingException("Due to indigestion issues, animals cannot be fed without an artist playing!");
		}
		// if no exceptions, feed the animal	
		else {
			animal.feed();
		}
	}

	/**
	 * Sometimes, artists get distracted, so there is a 50% chance that they start
	 * playing when you call this method. 
	 * 
	 */
	public void startPlaying() {
		// if we are already playing, don't risk getting distracted again
		if(!isPlaying) {
			// 50% chance we begin playing - 50/50
			if(Math.random() > 0.50) {
				// Artist begins playing and state it
				isPlaying = true;
				System.out.println("Artist has started playing!");
			}
		}
	}
	
	public void stopPlaying() {		
		// stop playing and state it
		isPlaying = false;
		System.out.println("Artist has stopped playing!");
	}
	
}
