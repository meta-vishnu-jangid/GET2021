package main;

import java.util.ArrayList;
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
		
		DBConnection dbConnection = new DBConnection(host, dbName, user_id, password);
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter User Id ( From 1 - 10 ) :");
		int userId = sc.nextInt();
		
		ArrayList<UserOrder> userOrders = dbConnection.getUserOrdersInShippedState(userId);
		
		System.out.println("\nUser Orders With ID 3 : ");
		for(UserOrder userOrder: userOrders){
			System.out.println("Order ID : " + userOrder.getOrderId() + ", Total : " 
					+ userOrder.getOrderToatal() + ", Date : " + userOrder.getOrderDate());
		}

		ArrayList<ProductImage> productImages = new ArrayList<ProductImage>();
		
		productImages.add(new ProductImage(1, "abc1"));
		productImages.add(new ProductImage(2, "abc2"));
		
		dbConnection.addProductImages(productImages);
		
		System.out.println("\nNumber of Deleted Products Which are not Orderes in Last 1 year : " 
				+ dbConnection.deleteProductNotOrderedInLast1Year());
		
		
		ArrayList<TopParentCategory> topParentCategories = dbConnection.getParentCategoryWithChildCategoryCount();
		
		System.out.println("\nTop Parent categories with Child Categories count: ");
		for(TopParentCategory topParentCategory : topParentCategories ){
			System.out.println("Category ID : " + topParentCategory.getCategoryId() +
					", Title : " + topParentCategory.getTitle() 
					+ ", Child Category Count : " + topParentCategory.getChildCategoryCount());
		}
		
		sc.close();
		dbConnection.close();
		
		
	}

}
