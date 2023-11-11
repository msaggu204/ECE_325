package ece325_lab_assignment4;

// CHECKED
// These special animals get indigestion when they are fed without
// an artist playing background music. So, you can only feed them
// after you started playing. If they come to you before you started
// playing, make sure to raise a NotPlayingException and start
// playing as soon as possible.
public class NotPlayingException extends Exception {
	public NotPlayingException(String message) {
		super(message);
	}
}