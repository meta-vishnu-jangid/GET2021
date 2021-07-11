package main;

import java.util.ArrayList;
import main.Product;
import main.CartItem;


public class ShoppingCart {
	
	private ArrayList<CartItem> listOfItemsInCart = new ArrayList<CartItem>(); 
	
	public ShoppingCart(){
		this.listOfItemsInCart.clear();
	}
   
	/**
	 * function for add Item to Cart or add more quantity of product
	 * @param product product object
	 */
	
	public void addItem(final Product product){
		
		final int default_quantity = 1;  //  default quantity for adding a product
		final int available_product_quantity =  product.getProductAvailableQuantity(); // for checking if enough quantity of product is available or not
		boolean isItemAlreadyPresentInCart = false ;
	
		if( available_product_quantity >= default_quantity ){ // If required Quantity is Present
			
			for( CartItem itemInCart : this.listOfItemsInCart  ){ // Checking if Item is already present in cart or not 
				
				if( itemInCart.getProduct().getProductId().equals(product.getProductId()) ){ // if Item is already present in cart then increase quantity
					
					itemInCart.addQuantity(default_quantity);
					isItemAlreadyPresentInCart = true ;
					break;
				}
			}
			
			if(!isItemAlreadyPresentInCart){
				
				CartItem itemToBeAdded = new CartItem(product);
				listOfItemsInCart.add(itemToBeAdded);
				
			}
			
		}
		
		else{
			System.out.println("Not enough Quantity Available");
		}
		
	}
	
	/**
	 * Method for remove Item from Cart or remove quantity present in Cart
	 * @param itemIdToBeRemoved
	 */
	public void removeItem(final String itemIdToBeRemoved ){
		
		int indexOfItemToBeRemoved = -1;
		int tempIndex = 0; // For finding index of Item in List
		final int default_quantity = 1;  
		
		for( CartItem itemInCart : this.listOfItemsInCart  ){ // Finding Index of Item to be removed in List of Items
			if( itemInCart.getProduct().getProductId().equals(itemIdToBeRemoved )){
				indexOfItemToBeRemoved = tempIndex;
				break;
			}
			tempIndex++;
		}
		
		if( indexOfItemToBeRemoved != -1 ){ // If Item is in List of Items in Cart
			
//			System.out.println(listOfItemsInCart.get(indexOfItemToBeRemoved).getItemDetails().get("quantity_needed").toString());
			final int previous_quantity_needed = listOfItemsInCart.get(indexOfItemToBeRemoved).getItemQauntityNeeded();  // The quantity needed by customer
		    
			if( previous_quantity_needed == default_quantity ){ // If the quantity needed is equals to default quantity then item will removed from List otherwise quantity will be decreased by default quantity
		    	
				this.listOfItemsInCart.get(indexOfItemToBeRemoved).removeQuantity(default_quantity);
				this.listOfItemsInCart.remove(indexOfItemToBeRemoved);
		    	
		    }
			else{
				
				this.listOfItemsInCart.get(indexOfItemToBeRemoved).removeQuantity(default_quantity);
			}
			
		}
		
	}
	
	/**
	 * Function to fetch List of Items in Cart
	 * @return  an ArraList of Items in Cart
	 */
	public ArrayList getListOfItems(){
		return this.listOfItemsInCart;
	}
	
	/**
	 * Function to calculate bill
	 * @return total price for billing
	 */
	public int generateBill(){
		
		int totalPrice = 0 ;
		int priceOfItem;
		int quantityNeeded;
		
		for( CartItem itemInCart : this.listOfItemsInCart  ){ 
		  priceOfItem = itemInCart.getProduct().getProductPrice();
		  quantityNeeded = itemInCart.getItemQauntityNeeded();
		  totalPrice += priceOfItem * quantityNeeded ;
		}
		
		return totalPrice;
	}
	
}
