package Milestone;
public class Pants extends Clothes {

	// creates a string length
	private String length;
	// created a constructor that takes 5 parameters, with length being unique to this subclass
	public Pants(String name, String description, double price, int quantity, String length) {
		super(name, description, price, quantity);
		this.length = length;
	}
	
	// getter for the length field
	public String getlength() {
		return length;
	}
	
	// overrides the original printout
	@Override
	public String toString() {
		return super.toString() + " Length: " + length;
	}
}
