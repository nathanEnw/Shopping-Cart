package Milestone;
public class Sweater extends Clothes{

	// creates a string material
	private String material;
	// created a constructor that takes 5 parameters, with material being unique to this subclass
	public Sweater(String name, String description, double price, int quantity, String material) {
		super(name, description, price, quantity);
		this.material = material;
	}
	
	// getter for the material field
	public String getMaterial() {
		return material;
	}
	
	// overrides the original print out
	@Override
	public String toString() {
		return super.toString() + " Material: " + material;
	}
}
