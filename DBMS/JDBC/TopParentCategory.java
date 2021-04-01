package main;

/**
 * Class to represent Top Parent Categories With Count of Child categories
 * @author vishnu.jangid_metacu
 *
 */
public class TopParentCategory {
	
	private final int category_id;
	private final String title;
	private final int child_categories_count;
	
	/**
	 * Constructor
	 * @param category_id int, id of parent category
	 * @param title String, title of parent category
	 * @param child_categories_count int, number of child categories in parent category
	 */
	public TopParentCategory(int category_id, String title, int child_categories_count) {
		this.category_id = category_id;
		this.child_categories_count = child_categories_count;
		this.title = title;
	}
	
	
	/**
	 * Method to get parent category ID
	 * @return int, parent category ID
	 */
	public int getCategoryId(){
		return this.category_id;
	}
	
	/**
	 * Method to get title of Parent Category
	 * @return String, title 
	 */
	public String getTitle(){
		return this.title;
	}
	
	
	/**
	 * Method to get numbers of Child Categories in Parent Category
	 * @return int, count of child category
	 */
	public int getChildCategoryCount(){
		return this.child_categories_count;
	}
}
