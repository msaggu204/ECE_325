package ece325_lab_assignment3;

public abstract class Equipment {
	private boolean needsWrapping;   // A variable indicate whether this kind of equipment needs wrapping 
	
	/**
	 * Constructor
	 * @param a boolean that indicates whether this type of equipment needs wrapping or not
	 */
	public Equipment(boolean needsWrapping) {
		setNeedsWrapping(needsWrapping);
	}
	
	public void setNeedsWrapping(boolean needsWrapping) {
		this.needsWrapping = needsWrapping;
	}
	
	public boolean getNeedsWrapping() {
		return needsWrapping;
	}
	
	/**
	 * Indicates whether some other equipment is the same type as this one.
	 * @param other equipment
	 */
	public boolean equals(Equipment e) {
		return (e.toString() == this.toString());
	}
	
	public abstract String toString();
}
