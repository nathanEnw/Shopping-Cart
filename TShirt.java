package Milestone;
public class TShirt extends Clothes {
	
	// creates a string color
	private String color;
	
	// created a constructor that takes 5 parameters, with color being unique to this subclass
	public TShirt(String name, String description, double price, int quantity, String color) {
		super(name, description, price, quantity);
		this.color = color;
	}
	
	// getter for string color
	public String getColor() {
		return color;
	}
	
	// overrides the original 
	@Override
	public String toString() {
		return super.toString() + " Color: " + color;
	}
}
