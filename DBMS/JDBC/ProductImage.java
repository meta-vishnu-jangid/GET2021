package main;

/**
 * Class to represent Product Image 
 * @author vishnu.jangid_metacu
 */
public class ProductImage {
	
	private final int product_id;
	private final String image_url;
	
	/**
	 * Constructor
	 * @param product_id int, id of product
	 * @param image_url String, url of Image to add to product with given product Id
	 */
	public ProductImage(int product_id, String image_url) {
		this.image_url = image_url;
		this.product_id = product_id;
	}
	
	/**
	 * Method to get Product ID
	 * @return int, product ID
	 */
	public int getProductId(){
		return this.product_id;
	}
	
	
	/**
	 * Method to get Image URL
	 * @return String, url of Image
	 */
	public String getImageUrl(){
		return this.image_url;
	}
}
