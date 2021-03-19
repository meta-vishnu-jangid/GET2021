package main;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Service {

	/**
	 * Method to get User Orders Which are in Shipped State
	 * @param user_id int , Id of User
	 * @param connection DBConnection
	 * @return ArrayList<UserOrder>, list of orders of User
	 * @throws SQLException, if Error in fetching User Orders
	 * @throws ClassNotFoundException, if given Connection does not found drivers
	 * @throws NullDBConnectionException, if conection is null 
	 */
	public static ArrayList<UserOrder> getUserOrdersInShippedState(int user_id, DBConnection connection) throws SQLException, ClassNotFoundException, NullDBConnectionException{
		
		if(connection == null){
			throw new NullDBConnectionException("DBConnection cannot be null!");
		}
		if(connection.getConnection() == null){
			connection.reconnect();
		}
		PreparedStatement statement;
		ArrayList<UserOrder> userOrders = new ArrayList<UserOrder>();
		
		
		statement = connection.getConnection().prepareStatement(
					"SELECT orders.id AS order_id, "+ 
				    " orders.order_time AS order_date,orders.total AS order_total" +
			        " FROM orders" +
			        " INNER JOIN order_item" +
			        " ON orders.id = order_item.order_id" +
			        " INNER JOIN users" +
			        " ON orders.user_id = users.id" +
			        " WHERE users.id = ? AND order_item.status = 'shipped' "  +
			        " ORDER BY orders.order_time DESC;"		);
			
		statement.setInt(1, user_id);
		ResultSet result = statement.executeQuery();
			
		while(result.next()){
			int order_id = result.getInt("order_id");
			Date order_date = result.getDate("order_date");
			float order_total = result.getFloat("order_total");
			userOrders.add(new UserOrder(order_id, order_date, order_total));
		}
		
		return userOrders;
	}
	
	/**
	 * Method to add product Images to database
	 * @param productImages ArrayList<ProductImage>, list of ProductImages
	 * @param connection DBConnection
	 * @throws SQLException, if error in adding Images to table
	 * @throws ClassNotFoundException, if Database Drivers Not Found 
	 * @throws NullDBConnectionException, if connection is null
	 */
	public static void addProductImages(ArrayList<ProductImage> productImages, DBConnection connection) throws SQLException, ClassNotFoundException, NullDBConnectionException {

		if(connection == null){
			throw new NullDBConnectionException("DBConnection cannot be null!");
		}
		if(connection.getConnection() == null){
			connection.reconnect();
		}
			PreparedStatement statement = connection.getConnection().prepareStatement("INSERT INTO product_image"
				+ "(product_id, image_url)"
					+ " VALUES  (?,  ?);") ;
			for(ProductImage productImage : productImages){
				statement.setInt(1, productImage.getProductId());
				statement.setString(2, productImage.getImageUrl());
				statement.addBatch();
			}
			
			statement.executeBatch();
			
		
	}
	
	
	/**
	 * Method to delete Products which are not ordered in Last 1 Year
	 * @param connection DBConnection
	 * @return int, number of deleted Products
	 * @throws SQLException, if there is an error in deleting products
	 * @throws ClassNotFoundException, if Database Drivers not found 
	 * @throws NullDBConnectionException, if connection is null 
	 */
	public static int deleteProductNotOrderedInLast1Year(DBConnection connection) throws SQLException, ClassNotFoundException, NullDBConnectionException{
		
		if(connection == null){
			throw new NullDBConnectionException("DBConnection cannot be null!");
		}
		if(connection.getConnection() == null){
			connection.reconnect();
		}
		int numberOfDeletedProducts = 0;
		
			PreparedStatement statement = connection.getConnection().prepareStatement("DELETE FROM product "
					+ " WHERE product.id NOT IN "
					+ " (  SELECT DISTINCT order_item.product_id FROM orders"
					+ " INNER JOIN order_item ON order_item.order_id = orders.id "
					+ " WHERE orders.order_time > ( DATE_SUB( CURDATE(), INTERVAL 1 YEAR) ) );"
					);
			
		numberOfDeletedProducts = statement.executeUpdate();
			
		
		return numberOfDeletedProducts;
	}
	
	
	/**
	 * Method to get List of Top Parent Categories With count of Their Child Categories
	 * @param connection DBConnection
	 * @return ArrayList<TopParentCategory> 
	 * @throws SQLException, if error in fetching Parent Categories
	 * @throws ClassNotFoundException, if JDBC Drivers not found
	 * @throws NullDBConnectionException, if connection is null
	 */
	public static ArrayList<TopParentCategory> getParentCategoryWithChildCategoryCount(DBConnection connection) throws SQLException, ClassNotFoundException, NullDBConnectionException{

		if(connection == null){
			throw new NullDBConnectionException("DBConnection cannot be null!");
		}
		if(connection.getConnection() == null){
			connection.reconnect();
		}
		ArrayList<TopParentCategory> topParentCategories = new ArrayList<TopParentCategory>();
		
		PreparedStatement statement = connection.getConnection().prepareStatement("SELECT "
				+ " parent_category.id as category_id, parent_category.title, "
				+ " count(child_category.id) as child_categories_count "
				+ " FROM category parent_category INNER JOIN category child_category"
				+ " ON child_category.parent_category = parent_category.id"
				+ " WHERE parent_category.parent_category is NULL GROUP BY"
				+ " parent_category.id ;");
			
		ResultSet result = statement.executeQuery();
			
		while(result.next()){
			int category_id = result.getInt("category_id");
			String title = result.getString("title");
			int child_categories_count = result.getInt("child_categories_count");
			topParentCategories.add(new TopParentCategory(category_id, title, child_categories_count));
		}
	
		return topParentCategories;
	}
}
