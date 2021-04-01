package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class for JDBC implementation
 * @author vishnu.jangid_metacu
 *
 */
public class MainApp {

	public static void main(String[] args) {
		
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "storefront";	
		String user_id = "root";
		String password = "passdb";
		
		//Initializing Database Connection
		DBConnection dbConnection = null;
		try {
			dbConnection = new DBConnection(host, dbName, user_id, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot find required Drivers Classes");
		} catch (SQLException e) {
			System.out.println("Error in Connecting to Database : " + e.getMessage());
		}
	
		
		// Getting User Orders
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Id ( From 1 - 10 ) :");
		
		int userId = -1;
		try{
			while(userId < 0){
				userId = sc.nextInt();
				if(userId < 0){
					System.out.println("Wrong Id (shoul be greater then 0 ) , Enter Again : ");
				}
			}
		}catch(InputMismatchException e){
			System.out.println("Wrong Input type !" );
		}
		
		ArrayList<UserOrder> userOrders = new ArrayList<UserOrder>();
		try {
			userOrders = Service.getUserOrdersInShippedState(userId, dbConnection);
		} catch (ClassNotFoundException | SQLException
				| NullDBConnectionException e1) {
			System.out.println(e1.getMessage());
		}
		
		System.out.println("\nUser Orders With ID " + userId + " : ");
		for(UserOrder userOrder: userOrders){
			System.out.println("Order ID : " + userOrder.getOrderId() + ", Total : " 
					+ userOrder.getOrderToatal() + ", Date : " + userOrder.getOrderDate());
		}

		// Adding Product Images
		ArrayList<ProductImage> productImages = new ArrayList<ProductImage>();
		productImages.add(new ProductImage(1, "abc1"));
		productImages.add(new ProductImage(2, "abc2"));
		
		try {
			Service.addProductImages(productImages, dbConnection);
		} catch (ClassNotFoundException | SQLException
				| NullDBConnectionException e2) {
			System.out.println(e2.getMessage());
		}
		
		
		// Deleting Products Not Ordered in Last 1 Year
		try {
			System.out.println("\nNumber of Deleted Products Which are not Orderes in Last 1 year : " 
					+ Service.deleteProductNotOrderedInLast1Year(dbConnection));
		} catch (ClassNotFoundException | SQLException
				| NullDBConnectionException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		// Getting Top Product Categories
		ArrayList<TopParentCategory> topParentCategories = new ArrayList<TopParentCategory>();
		try {
			topParentCategories = Service.getParentCategoryWithChildCategoryCount(dbConnection);
		} catch (ClassNotFoundException | SQLException
				| NullDBConnectionException e1) {
			System.out.println(e1.getMessage());
		}
		
		System.out.println("\nTop Parent categories with Child Categories count: ");
		for(TopParentCategory topParentCategory : topParentCategories ){
			System.out.println("Category ID : " + topParentCategory.getCategoryId() +
					", Title : " + topParentCategory.getTitle() 
					+ ", Child Category Count : " + topParentCategory.getChildCategoryCount());
		}
		
		
		
		// Closing Connection and Scanner Class
		try{
			sc.close();
		}catch(Exception e){
			System.out.println("Error in closing Scanner");
		}
		try {
			if(dbConnection != null){
				dbConnection.close();	
			}
		} catch (SQLException e) {
			System.out.println("Error in closing database Connection");
		}
		
		
	}

}
