package Milestone;
import java.util.ArrayList;
import java.util.List;
public class Inventory<T extends Product>{

	// stores products in an ArrayList
	private ArrayList<T> products;
	
	// creates an empty array list
	public Inventory() {
		products = new ArrayList<T>();
	}
	
	// add products to inventory list
	public void addProduct(T product) {
		products.add(product);
	}
	
	// creates a public products list
	public ArrayList<T> getProducts(){
		return products;
	}
	
	// remove products to inventory list
	public void removeProduct(T product) {
		products.remove(product);
	}
	// get quantity of products in the list
	public int getQuantity(T product) {
		return product.getQuantity();
	}
	
	// set quantity of products in the list
	public void setQuantity(T product, int quantity) {
		product.setQuantity(quantity);
	}
	
	// get product index
	public T getProduct(int index) {
		return products.get(index);
	}
	
	//get the number of products in the list
	public int getNumProducts() {
		return products.size();
	}

	public void updateInventory(List<Product> products2) {
		// TODO Auto-generated method stub
		
	}

	public List<Product> getInventory() {
		// TODO Auto-generated method stub
		return null;
	}
	
}