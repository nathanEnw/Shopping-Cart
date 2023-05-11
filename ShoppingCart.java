package Milestone;
/* creating a new class ShoppingCart extending from the products
 * this class has 4 arguments for name, description, price and quantity
 */
import java.util.ArrayList;
import java.util.List;

import Interfaces.Purchasable;
public class ShoppingCart<T extends Product>{
	// creates the list for products
		private List<T> products;

  // constructor for ShoppingCart, it creates an ArrayList of products
  public ShoppingCart() {
    products = new ArrayList<T>();
  }
  
  private List<Purchasable> items;
  
  public void addProduct(Purchasable item) {
	  items.add(item);
  }
  // adding ability to add products
  public void addProduct(T product) {
    products.add(product);
  }
  // adding ability to remove products
  public void removeProduct(int index) {
    products.remove(index);
  }
  // adding ability to retrieve products
  public T getProduct(int index) {
    return products.get(index);
  }
  // get total number of items in list. It also adds the quantities of products
  public int getNumItems() {
    int numItems = 0;
    for (T product : products) {
      numItems += product.getQuantity();
    }
    return numItems;
  }

  // shows size of the list of products
  public int getSize() {
    return products.size();
  }

  // Adds up individual prices to get total amount
  public double getTotal() {
	  double total = 0;
	  for (T product : products) {
	    total += product.getPrice();
	  }
	  return total;
	}

  // clears contents of the list
  public void clear() {
    products.clear();
  }
  
  // prints out the products in the shopping cart
  public void display() {
	  for (int i = 0; i < products.size(); i++) {
		  System.out.println((i + 1) + ": " + products.get(i));
	  }
  }
public ArrayList<T> getProducts() {
	// TODO Auto-generated method stub
	return (ArrayList<T>) products;
}
}