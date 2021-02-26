package main;

import java.util.Hashtable;

import main.Product;

public class CartItem {
	
	private Product product;
	private int quantity_needed;
	private final int initial_quantity = 1 ; 
	
	/**
	 * Create a CartItem object 
	 * @param product 
	 */
	public CartItem( final Product product )
	{
		
		this.product = product;
		this.quantity_needed = this.initial_quantity ;
		this.product.decreaseProductAvailableQuantityBy(initial_quantity);
		
	}
	
	/**
	 * Add more quantity of Product
	 * @param quantityToAdd requires quantityToAdd > 0
	 */
	public void  addQuantity( final int quantityToAdd ){
		this.quantity_needed += quantityToAdd;
		product.decreaseProductAvailableQuantityBy(quantityToAdd);
	}
	
	/**
	 * Remove Quantity of Product
	 * @param quantityToRemove requires quantityToRemove > 0
	 */
	public void  removeQuantity( final int quantityToRemove ){
		this.quantity_needed -= quantityToRemove;
		product.increaseProductAvailableQuantityBy(quantityToRemove);
	}
	
	
	public Product getProduct(){
		return this.product;
	}
	
	/**
	 * Method to get Item Quantity Needed by Customer
	 * @return Item Quantity Needed 
	 */
	public int getItemQauntityNeeded(){
		return this.quantity_needed;
	}
	
}
