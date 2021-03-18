package main;
import java.sql.*;
import java.util.ArrayList;

/**
 * Class For Connection and Querying To DATABASE
 * @author vishnu.jangid_metacu
 */
public class DBConnection {
	
	private Connection connection = null;
	private String host, dbName, user_id, password;
	
	/**
	 * Constructor to initialize database Connection
	 * @param host String, host
	 * @param dbName String, database Name
	 * @param user_id String, user id for database
	 * @param password String, password of user
	 */
	public DBConnection(String host, String dbName, String user_id, String password) {
		this.host = host;
		this.dbName = dbName;
		this.user_id = user_id;
		this.password = password;
		connect();
	}
	
	/**
	 * Connect to database
	 */
	private void connect(){
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch ( ClassNotFoundException cnfe) {
		    System.out.println("Error loading driver: " +  cnfe);
		}
		
		String mysqlURL = this.host + this.dbName;
		
		try {
			this.connection = DriverManager.getConnection(mysqlURL,this.user_id, this.password);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}	     
	}
	
	/**
	 * Reconnect
	 */
	public void reconnect(){
		if(this.connection == null){
			connect();
		}
	}

	/**
	 * Close Database Connection
	 * @return
	 */
	public boolean close(){
		boolean isClosed = false;
		try {
			this.connection.close();
			this.connection = null;
			isClosed = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return isClosed;
	}
	
	/**
	 * Method to get User Orders Which are in Shipped State
	 * @param user_id int , Id of User
	 * @return ArrayList<UserOrder>, list of orders of User
	 */
	public ArrayList<UserOrder> getUserOrdersInShippedState(int user_id){
		
		PreparedStatement statement;
		ArrayList<UserOrder> userOrders = new ArrayList<UserOrder>();
		
		try {
			statement = connection.prepareStatement(
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
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return userOrders;
	}
	
	/**
	 * Method to add product Images to database
	 * @param productImages ArrayList<ProductImage>, list of ProductImages
	 */
	public void addProductImages(ArrayList<ProductImage> productImages) {
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO product_image"
					+ "(product_id, image_url)"
					+ " VALUES  (?,  ?);") ;
			for(ProductImage productImage : productImages){
				statement.setInt(1, productImage.getProductId());
				statement.setString(2, productImage.getImageUrl());
				statement.addBatch();
			}
			
			statement.executeBatch();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	/**
	 * Method to delete Products which are not ordered in Last 1 Year
	 * @return int, number of deleted Products
	 */
	public int deleteProductNotOrderedInLast1Year(){
		int numberOfDeletedProducts = 0;
		try{
			PreparedStatement statement = connection.prepareStatement("DELETE FROM product "
					+ " WHERE product.id NOT IN "
					+ " (  SELECT DISTINCT order_item.product_id FROM orders"
					+ " INNER JOIN order_item ON order_item.order_id = orders.id "
					+ " WHERE orders.order_time > ( DATE_SUB( CURDATE(), INTERVAL 1 YEAR) ) );"
					);
			
		numberOfDeletedProducts = statement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return numberOfDeletedProducts;
	}
	
	
	/**
	 * Method to get List of Top Parent Categories With count of Their Child Categories
	 * @return ArrayList<TopParentCategory> 
	 */
	public ArrayList<TopParentCategory> getParentCategoryWithChildCategoryCount(){
		ArrayList<TopParentCategory> topParentCategories = new ArrayList<TopParentCategory>();
		try{
			PreparedStatement statement = connection.prepareStatement("SELECT "
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
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return topParentCategories;
	}
	
	
}
