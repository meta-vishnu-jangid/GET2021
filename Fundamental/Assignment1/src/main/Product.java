package main;

import java.util.Dictionary;
import java.util.Hashtable;

public class Product {
	
	private String product_id ;  // unique_id for identification of product
	private String product_name ;
	private int product_price ;
	private int product_available_quantity ;
	
	/**
	 * Constructor for making a Product Object
	 * @param product_id , must be unique
	 * @param product_name 
	 * @param product_price
	 * @param product_quantity
	 */
	public Product(final String product_id,final String product_name,final int product_price, final int product_available_quantity){
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_available_quantity = product_available_quantity ;
	}
	
	
	/**
	 * Get Details of Product
	 * @return Dictionary contains Product Details
	 */
	
	public Dictionary getProductDetails(){
		
		Dictionary product_details = new Hashtable();
		product_details.put("product_id", this.product_id);
		product_details.put("product_name",this.product_name);
		product_details.put("product_price",this.product_price);
		product_details.put("product_available_quantity",this.product_available_quantity);
		return product_details;
		
	}
	
	/**
	 * Function to add quantity of Product
	 * @param quantity_to_be_added 
	 */
	public void increaseProductAvailableQuantityBy(final int quantity_to_be_added){
		this.product_available_quantity += quantity_to_be_added ;
	}
	
	/**
	 * Function to remove quantity of Product
	 * @param quantity_to_be_removed
	 */
	public void decreaseProductAvailableQuantityBy(final int quantity_to_be_removed){
		this.product_available_quantity -= quantity_to_be_removed ;
	}
	
}
