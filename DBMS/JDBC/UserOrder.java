package main;

import java.sql.Date;

/**
 * Class to represent a User Order
 * @author vishnu.jangid_metacu
 */
public class UserOrder {
	private final int order_id ;
	private final Date order_date ;
	private final float order_total;
	
	/**
	 * Constructor
	 * @param order_id int, id of order
	 * @param order_date Date, date of Order
	 * @param order_total float, total price of Order
	 */
	public UserOrder(int order_id, Date order_date, float order_total) {
		this.order_date = order_date;
		this.order_id = order_id;
		this.order_total = order_total;
	} 
	
	
	/**
	 * Method to get Order ID
	 * @return int, order ID
	 */
	public int getOrderId(){
		return this.order_id;
	}
	
	
	/**
	 * Method to get Order Total Price
	 * @return float, total price of Order
	 */
	public float getOrderToatal(){
		return this.order_total;
	}
	
	
	/**
	 * Method to get date of Order.
	 * @return Date, order date
	 */
	public Date getOrderDate(){
		return this.order_date;
	}
}