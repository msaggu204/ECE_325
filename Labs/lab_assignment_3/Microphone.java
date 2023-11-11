package ece325_lab_assignment3;

public class Microphone extends Equipment {
	// If we're adding equipment, it needs to be wrapped!
	public Microphone(boolean needsWrapping) {
		super(needsWrapping);
	}

	@Override
	public String toString() {
		return "microphone";
	}
	
	// Don't really need implementations of the following characteristics
	// and behaviors but it's here if needed in the future
	public boolean turnOn() {
		return true;
	}
	
	public boolean turnOff() {
		return true;
	}
	
	public String makeSound() {
		return "Mic check!";
	}
}
