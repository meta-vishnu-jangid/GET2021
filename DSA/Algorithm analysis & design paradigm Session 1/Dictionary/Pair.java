package main;

public class Pair {
	
	private String key;
	private String value;
	
	/**
	 * Constructor For Pair
	 * @param key 
	 * @param value
	 */
	public Pair(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * Get Key of Pair
	 * @return String, key
	 */
	public String getKey(){
		return key;
	}
	
	/**
	 * Get Value of Pair
	 * @return String, value
	 */
	public String getValue(){
		return value;
	}
}