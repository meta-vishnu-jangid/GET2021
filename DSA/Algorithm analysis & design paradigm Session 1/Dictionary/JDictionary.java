package main;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class For Dictionary
 * @author vishnu.jangid_metacu
 *
 */
public class JDictionary{
	
	private BST tree ;
	
	/**
	 * Default Constructor
	 */
	public JDictionary() {
		this.tree = new BST();
	}
	
	/**
	 * Constructor to initialize Dictionary Object
	 * @param jsonString String, JSON in form of String like {a:1,b:2}
	 * @throws AssertionError if invalid JSON string passed
	 */
	public JDictionary(String jsonString) throws AssertionError {
		this.tree = new BST();
		try {
			JSONObject json = new JSONObject(jsonString.trim());
			Iterator<String> keys = json.keys();
			while(keys.hasNext()){
				String key = keys.next();
				String value = json.getString(key);
				this.tree.addNode(tree.headNode, key, value);
			}
			
		} catch (JSONException e) {
			throw new AssertionError("Invlaid JSON string");
		}
	}
	
	/**
	 * Method to add Pair to Dictionary
	 * @param key String
	 * @param value String
	 * @throws AssertionError if any of PArameter is null
	 */
	public void add(String key, String value) throws AssertionError {
		if(key == null || value == null) {
			throw new AssertionError("Parameters Cannot be null");
		}
		tree.addNode(tree.headNode, key, value);
	}
	
	/**
	 * Method to remove pair with particular key
	 * @param key String
	 * @return boolean, true if successfully deleted or false if pair with key not found
	 * @throws AssertionError id key is null
	 */
	public boolean remove(String key) throws AssertionError {
		if(key == null) {
			throw new AssertionError("Key Cannot be null");
		}
		return tree.deleteNode(tree.headNode,key);
	}
	
	/**
	 * Get value for particular Value
	 * @param key String
	 * @return String, value for specified key
	 * @throws AssertionError if key is null or don't find any pair with specified key
	 */
	public String get(String key) throws AssertionError{
		if(key == null) {
			throw new AssertionError("Key Cannot be null");
		}
		Node node = tree.getNode(tree.headNode, key);
		if(node == null){
			throw new AssertionError("Pair Not Found");
		}
		return node.value;
	}
	
	/**
	 * Method to get List Sorted By Key
	 * @return Pair[], sorted array of Pair 
	 */
	public Pair[] getSortedList(){
		ArrayList<Node> sortedList = new ArrayList<Node>();
		sortedList = tree.getSortedList(tree.headNode, sortedList);
		
		ArrayList<Pair> sortedPair = new ArrayList<Pair>();
		for(Node node : sortedList){
			sortedPair.add(new Pair(node.key, node.value));
		}
		
		return sortedPair.toArray(new Pair[sortedPair.size()]); 
	}
	
	/**
	 * Method to get List Sorted By Key in which key ranges from key1 to key2
	 * @param key1 String
	 * @param key2 String
	 * @return Pair[], sorted array of Pair
	 */
	public Pair[] getSortedListInRange(String key1, String key2){
		
		ArrayList<Node> sortedList = new ArrayList<Node>();
		sortedList = tree.getSortedListInRange(tree.headNode, sortedList, key1, key2);
		
		ArrayList<Pair> sortedPair = new ArrayList<Pair>();
		for(Node node : sortedList){
			sortedPair.add(new Pair(node.key, node.value));
		}
		
		return sortedPair.toArray(new Pair[sortedPair.size()]); 
	}
	
}
