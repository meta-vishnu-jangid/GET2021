package main;

import java.util.ArrayList;

/**
 * Class For Binary Search Tree
 * @author vishnu.jangid_metacu
 *
 */
public class BST {
	
	public Node headNode;
	
	/**
	 * Constructor
	 */
	public BST() {
		this.headNode = null;
	}
	
	/**
	 * Add node to BST
	 * @param root Node, the root node
	 * @param key String, value of Key
	 * @param value String , value
	 */
	public void addNode(Node root, String key, String value) {
		if(root == null) {
			root = new Node(key,value);
			if(this.headNode == null){
				this.headNode = root;
			}
		}
		else if(root.key.compareTo(key) == 0){
			boolean isAdded  = true;
			root.value = value;
		}
		else {
			if(root.key.compareTo(key) > 0 ) {
				if(root.leftChild == null){
					Node newNode = new Node(key,value);
					root.leftChild = newNode;
					newNode.parentNode = root;
				}
				else{
					addNode(root.leftChild, key, value);
				}
			}
			else if (root.key.compareTo(key) < 0 ) {
				if(root.rightChild == null) {
					Node newNode = new Node(key,value);
					root.rightChild = newNode;
					newNode.parentNode = root;
				}
				else{
					addNode(root.rightChild, key, value);
				}
				
			}
		}
	}
	
	/**
	 * Delete Node For having particular Key
	 * @param root Node, root node
	 * @param key String, key
	 * @return boolean, true if node deleted or false if node with specified key not found
	 */
	public boolean deleteNode(Node root,String key) {
		if(root == null) {
			return false;
		}
		
		if (key.compareTo(root.key) < 0)
            return deleteNode(root.leftChild, key);
        else if (key.compareTo(root.key) > 0)
             return deleteNode(root.rightChild, key);
        else {
        	
			if(root.leftChild == null && root.rightChild == null) {
				if(root == this.headNode ){
					this.headNode = null;
				}
				else if(root == root.parentNode.leftChild) {
					root.parentNode.leftChild = null;
				}
				else {
					root.parentNode.rightChild = null;
				}
			}
			
			else if(root.leftChild == null && root.rightChild != null) {
				if(root == this.headNode){
					this.headNode = root.rightChild;
					root.rightChild.parentNode = null;
				}
				else if(root == root.parentNode.leftChild) {
					root.parentNode.leftChild = root.rightChild;
					root.rightChild.parentNode = root.parentNode;
				}
				else {
					root.parentNode.rightChild = root.rightChild;
					root.rightChild.parentNode = root.parentNode;
				}
			}
			
			else if(root.leftChild != null && root.rightChild == null) {
				if(root == this.headNode){
					this.headNode = root.leftChild;
					root.leftChild.parentNode = null;
				}
				if(root == root.parentNode.leftChild) {
					root.parentNode.leftChild = root.leftChild;
					root.leftChild.parentNode = root.parentNode;
				}
				else {
					root.parentNode.rightChild = root.leftChild;
					root.leftChild.parentNode = root.parentNode;
				}
			}
			
			else {
				Node nodeToReplace = minKey(root.rightChild);
				nodeToReplace.parentNode.leftChild = nodeToReplace.rightChild; 
				nodeToReplace.rightChild.parentNode = nodeToReplace.parentNode;
				if(root == this.headNode){
					this.headNode = nodeToReplace;
					this.headNode.leftChild  = root.leftChild;
					this.headNode.rightChild = root.rightChild;
					this.headNode.parentNode = null;
				}
				else if(root == root.parentNode.leftChild) {
					root.parentNode.leftChild = nodeToReplace;
					nodeToReplace.leftChild  = root.leftChild;
					nodeToReplace.rightChild = root.rightChild;
					nodeToReplace.parentNode = root.parentNode;
				}
				else {
					root.parentNode.rightChild = nodeToReplace;
					nodeToReplace.leftChild  = root.leftChild;
					nodeToReplace.rightChild = root.rightChild;
					nodeToReplace.parentNode = root.parentNode;
				}
				
			}
			
			return true;
		}
		
	}
	
	/**
	 * Returns Min Key Node 
	 * @param root Node, Node to start with
	 * @return Node, required Node
	 */
	private Node minKey(Node root)
    {
        while (root.leftChild != null) 
        {
            root = root.leftChild;
        }
        return root;
    }
	
	/**
	 * Get Node With Specified Key
	 * @param root Node, root Node
	 * @param key String, Key to Search For
	 * @return Node, required Node or null if dont't have required Node
	 */
	public Node getNode(Node root, String key) {
		if(root == null){
			return root;
		}
		if(root.key.equals(key)) {
			return root;
		}
		else if(root.key.compareTo(key) > 0) {
			return getNode(root.leftChild, key);
		}
		else {
			return getNode(root.rightChild, key);
		}
	}
	
	/**
	 * Get Sorted List of Nodes
	 * @param root Node, root node
	 * @param sortedList ArrayList<Node>, List of Sorted Node
	 * @return ArrayList<Node>, list of Nodes sorted according to Key
	 */
	public ArrayList<Node> getSortedList( Node root ,ArrayList<Node> sortedList ){
		if(root.leftChild == null && root.rightChild == null){
			sortedList.add(root);
		}
		else{
			if(root.leftChild != null){
				getSortedList(root.leftChild, sortedList);	
			}
			sortedList.add(root);
			if(root.rightChild != null){
				getSortedList(root.rightChild, sortedList);	
			}
		}
		return sortedList;
	}
	
	/**
	 * Get Sorted List of Nodes with Key VAlue between Key1 and key2
	 * @param root Node, root node
	 * @param sortedList ArrayList<Node>, List of Sorted Node
	 * @param key1 String
	 * @param key2 String
	 * @return ArrayList<Node>, list of Nodes sorted according to Key
	 */
	public ArrayList<Node> getSortedListInRange( Node root ,ArrayList<Node> sortedList, String key1, String key2 ){
		if(root.leftChild == null && root.rightChild == null ){
			if(root.key.compareTo(key1) >= 0   && root.key.compareTo(key2) <= 0){
				sortedList.add(root);
			}
		}
		else{
			if(root.leftChild != null && root.key.compareTo(key1) > 0){
				getSortedList(root.leftChild, sortedList);	
			}
			if(root.key.compareTo(key1) >= 0   && root.key.compareTo(key2) <= 0){
				sortedList.add(root);
			}
			if(root.rightChild != null && root.key.compareTo(key2) < 0){
				getSortedList(root.rightChild, sortedList);	
			}
		}
		return sortedList;
	}
	
}