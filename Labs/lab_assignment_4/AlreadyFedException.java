package ece325_lab_assignment4;

// CHECKED EXCEPTION
// Every animal can only be fed once per day. 
// Raise an AlreadyFedException when an animal comes to you who has
// already been fed today. Note that the animals are more than happy
// to be fed more than once a day... so they should probably not be 
// expected to raise this exception themselves.
public class AlreadyFedException extends Exception {
	public AlreadyFedException(String message) {
		super(message);
	}
}