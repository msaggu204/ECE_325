package ece325_lab_assignment4;

public class ZooShow {
	
	public static void main(String[] args) {
		// create the artist
		Artist artist = new Artist();
		
		// create the zoo
		Zoo zoo = new Zoo();
		
		// while there are animals that still need feeding,
		// randomly select an animal from the zoo
		// feed it
		while(!zoo.allAnimalsFed()) {
			// It isn't guaranteed the artist begins to play because
			// they're forgetful, so we must have it in the while loop
			// until they begin. Show begins when an animal approaches
			ZooAnimal animal = zoo.getRandomAnimalToComeToStage();
			// Animal has approached - attempt to start playing
			artist.startPlaying();
			try {
				artist.feed(animal);
			}
			catch (AlreadyFedException e) {
				// Print to System.err if animal tries more than once
				e.printStackTrace();
			}
			catch (NotPlayingException e) {
				e.printStackTrace();
			}
			
		}
		
		// stop playing when all animals are fed
		System.out.println("All animals are fed!");
		// Cannot stop playing until all animals have been fed
		artist.stopPlaying();
	}
}
