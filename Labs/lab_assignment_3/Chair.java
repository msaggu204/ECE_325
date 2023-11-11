package ece325_lab_assignment3;

public class Chair extends Equipment {
	// Chairs are not an instrument, so they don't need to be wrapped
	// Still a type of equipment
	public Chair(boolean needsWrapping) {
		super(needsWrapping);
	}

	@Override
	public String toString() {
		return "chair";
	}
	// Extra behaviors or characteristics not required for a chair
}
