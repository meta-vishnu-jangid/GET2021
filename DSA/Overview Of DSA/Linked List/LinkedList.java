package main;

/**
 * Class to Represent Linked List
 * @author vishnu.jangid_metacu
 *
 */
public class LinkedList {
	
	private Node head;
	private Node lastNode;
	private int size;
	
	/**
	 * Initialize a LinkedList
	 */
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	
	/**
	 * Add Item into Linked List
	 * @param data int
	 */
	public void add(int data){
		Node node = new Node(data);
		node.next = null;
		if(this.head == null){
			this.head = node;
			this.lastNode = node;
		}
		else{
			this.lastNode.next = node;
			this.lastNode = node;
		}
		this.size++;
	}
	
	
	/**
	 * Method to get a temp Linked List which having a loop
	 * @return LinkedList
	 */
	public LinkedList getLinkedListHavingLoop(){
		LinkedList linkedList = new LinkedList();
		
		Node node1 = new Node(2);
		Node node2 = new Node(3);
		Node node3 = new Node(4);
		
		linkedList.head = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node1;
		
		return linkedList;
	}
	
	
	/**
	 * Method to rotate sub list into clockwise direction by particualr no. of rotations
	 * @param left int, First Element number of Sub List 
	 * @param right int , Last Element number of Sub List
	 * @param numberOfRotations int, number of Rotations
	 */
	public void rotateSubList(int left, int right, int numberOfRotations){
		if(right > this.size){
			throw new AssertionError("Invalid Right Position");
		}
		if(left < 1 ){
			throw new AssertionError("Invalid Left Position");
		}
		
		int numberOfNodes = right-left+1;
		numberOfRotations = numberOfRotations%(numberOfNodes);
		Node[] nodeArray = new Node[numberOfNodes];
		Node nodeLeftToSubList = null;
		Node nodeRightToSubList;
		int index = 0;
		Node nodeInLinkedList = this.head;
		for(int i = 1; i<= right; i++){
			if(i >= left){
				nodeArray[index] = nodeInLinkedList;
				index++;
			}
			if(i == left-1){
				nodeLeftToSubList = nodeInLinkedList;
			}
			nodeInLinkedList = nodeInLinkedList.next;
		}
		nodeRightToSubList = nodeInLinkedList;
		for(int i = 0;i<= numberOfNodes -1;i++){
			if(nodeLeftToSubList == null){
				this.head = nodeArray[(i-numberOfRotations + numberOfNodes)%(numberOfNodes)];
				nodeLeftToSubList = this.head;
			}
			else{
				nodeLeftToSubList.next = nodeArray[(i-numberOfRotations + numberOfNodes)%(numberOfNodes)];
				nodeLeftToSubList = nodeLeftToSubList.next;
			}
		}
		nodeLeftToSubList.next = nodeRightToSubList;
	}
	
	/**
	 * Method to print content of Linked List
	 */
	public void showList(){
		Node start = this.head;
		while(start!=null){
			System.out.print(start.data+ " -> ");
			start = start.next;
		}
		System.out.println("End");
	}
	
	
	/**
	 * Method to detect is Linked List having a loop or not
	 * @return boolean, true if have a loop otherwise false
	 */
	public boolean haveLoop(){
		Node start1 = this.head;
		while(start1 != null){
			Node start2 = start1.next;
			while(start2 != null){
				if(start1 == start2){
					return true;
				}
				start2 = start2.next;
			}
			start1 = start1.next;
		}
		return false;
	}
	
}
