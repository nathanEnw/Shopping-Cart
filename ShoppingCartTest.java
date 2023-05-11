package test;

import org.junit.Test;

import Milestone.Product;
import Milestone.ShoppingCart;
import Milestone.TShirt;
import Interfaces.Purchasable;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;

public class ShoppingCartTest {

	@Test
	public void testAddProductT() {
		ShoppingCart<Product> shoppingCart = new ShoppingCart<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		cart.addProduct(tShirt);
		assertEquals(1, cart.getSize());
		assertEquals(tShirt, cart.getProduct(0));
	}

	@Test
	public void testGetProduct() {
		ShoppingCart<Product> shoppingCart = new ShoppingCart<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		ShoppingCart<Product> cart;
		cart.getProduct(tShirt);
		assertEquals(tShirt, cart.getProduct(0));
	}

	@Test
	public void testGetNumItems() {
		ShoppingCart<Product> shoppingCart = new ShoppingCart<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		cart.addProduct(tShirt);
		assertEquals(15, cart.getSize());
	}

	@Test
	public void testGetSize() {
		ShoppingCart<Product> shoppingCart = new ShoppingCart<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		cart.addProduct(tShirt);
		assertEquals(1, cart.getSize());
	}

	@Test
	public void testGetTotal() {
		ShoppingCart<Product> shoppingCart = new ShoppingCart<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		cart.addProduct(tShirt);
		assertEquals(200.00, cart.getTotal(),0.00);
	}

	@Test
	public void testClear() {
		ShoppingCart<Product> shoppingCart = new ShoppingCart<Product>();
		Product product = new TShirt ("T-Shirt","A short sleeve graphic shirt", 19.99, 15, "Red");
		cart.addProduct(tShirt);
		cart.clear();
		assertEquals(0, cart.getSize());
	}
}