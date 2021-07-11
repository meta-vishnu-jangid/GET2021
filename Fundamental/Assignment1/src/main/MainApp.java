package main;
import java.util.ArrayList;
import java.util.Dictionary;

import main.CartItem;
import main.Product;
import main.ShoppingCart;

public class MainApp {

	public static void displayCartItems( final ShoppingCart cart ){
		
		ArrayList<CartItem> listOfItemsInCart = cart.getListOfItems();
		for( CartItem item : listOfItemsInCart ){
			System.out.println(item.getProduct().getProductName() + " : " + item.getItemQauntityNeeded());
		}
	}
	
	public static void main(String[] args) {
		
	  //  Creating Products 
		
      Product orange = new Product("id1","Orange",20,22);
      Product biscuit = new Product("id2","Biscuits",30,15);
      Product namkeen = new Product("id3","Namkeen",70,1);

      System.out.println("Products List : " +"\n ");
      System.out.println("Name : " + orange.getProductName() + " , Quantity : " + orange.getProductAvailableQuantity());
      System.out.println("Name : " + biscuit.getProductName() + ",  Quantity : " + biscuit.getProductAvailableQuantity());
      System.out.println("Name : " + namkeen.getProductName() + ",  Quantity : " + namkeen.getProductAvailableQuantity());
     
      
      
      ShoppingCart cart1 = new ShoppingCart();
      
      
      cart1.addItem(orange);
      cart1.addItem(orange);
      cart1.addItem(biscuit);
      cart1.addItem(namkeen);
      cart1.addItem(namkeen);
     
      System.out.println("\nAfter Adding Items To Cart : " +"\n ");
      
      displayCartItems(cart1);
      
      cart1.removeItem("id1");
      cart1.removeItem("id3");
      
      System.out.println("\nAfter Removing Items To Cart : " +"\n ");
      
      displayCartItems(cart1);
      
      System.out.println("\n Total Price :" + cart1.generateBill());
     
	}
}
