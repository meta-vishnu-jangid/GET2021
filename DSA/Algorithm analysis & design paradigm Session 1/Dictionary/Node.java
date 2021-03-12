package main;

public class Node {
	
	public String key;
	public String value;
	public Node leftChild ;
	public Node rightChild;
	public Node parentNode ;
	
	/**
	 * Constructor for Node class
	 * @param key String
	 * @param value String
	 */
	public Node(String key, String value) {
		this.key = key;
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parentNode = null;
	}
}