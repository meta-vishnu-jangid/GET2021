package main;

import java.util.ArrayList; 

/**
 * Class to Implement Circular Queue
 * @author vishnu.jangid_metacu
 *
 * @param <E> , type of Data supported by Queue
 */
class CircularQueue<E>{ 
	
	private int size ;
	private int front;
	private int rear; 
	private int noOfElements;

	private Object[] queue ; 


	/**
	 * Initialize CircularQueue Object
	 * @param size int, size of Queue
	 */
	CircularQueue(int size){
		queue = new Object[size];
		this.size = size; 
		this.front = -1;
		this.rear = -1; 
		this.noOfElements = 0;
	}	 

	/**
	 * Method to put data into Queue
	 * @param data E,
	 * @return boolean, true if successfully inserted
	 * @throws AssertionError if Queue is Full and no more element can be inserted
	 */
	public boolean enQueue(E data) throws AssertionError{  
		if(isFull()){
			throw new AssertionError("Queue is Full");
		}
		else if(front == -1){ 
			front = 0; 
			rear = 0; 
			queue[rear] = data;
		} 

		else if(rear == size - 1) { 
			rear = 0; 
			queue[rear] = data; 
		} 

		else{ 
			rear = (rear + 1);
			queue[rear] = data; 
		} 
		this.noOfElements ++;
		return true;
	} 
	
	
	/**
	 * Method to remove element form Queue
	 * @return E, element removed
	 * @throws AssertionError if Queue is Empty
	 */
	public E deQueue() throws AssertionError{ 
		if(isEmpty()){
			throw new AssertionError("Queue is Empty");
		}
		
		E temp; 
	
		temp = (E)this.queue[this.front]; 
	
		// Condition for only one element 
		if(front == rear){ 
			front = -1; 
			rear = -1; 
		} 
	
		else if(front == size - 1) { 
			front = 0; 
		} 
		else{ 
			front = front + 1; 
		} 
		this.noOfElements --;
		
		return temp; 
	} 
	
	
	/**
	 * Method to get Queue as Array
	 * @return E[], array of elements of Queue 
	 */
	public E[] getQueue(){
		Object[] newQueue = new Object[this.noOfElements];
		if(isEmpty()){
		}
		else if(front <= rear ){
			for(int index = front,i = 0; index <= rear; index++,i++){
				newQueue[i] = this.queue[index];
			}
		}
		else{
			int lastIndex = 0;
			for(int index = front,i = 0; index <= this.size-1; index++, i++){
				newQueue[i] = this.queue[index];
				lastIndex = i;
			}
			for(int index = 0,i = lastIndex+1; index<= this.rear; index++, i++){
				newQueue[i] = this.queue[index];
			}
		}
		return (E[]) newQueue;
	}
	
	
	/**
	 * Method to check if Queue is Empty
	 * @return true if queue is Empty, otherwise false
	 */
	public boolean isEmpty(){
		if(front == -1){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	* Method to check if Queue is Full
	* @return true if queue is Full, otherwise false
	*/
	public boolean isFull(){
		if((this.front == 0 && this.rear == this.size - 1) || (this.rear == (this.front - 1)) ){ 
			return true;
		} 
		else{
			return false;
		}
	}
} 