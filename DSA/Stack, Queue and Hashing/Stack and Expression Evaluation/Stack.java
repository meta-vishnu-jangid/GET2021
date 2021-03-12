package main;

/**
 * Class For Implementing Stack using Array
 * @author vishnu.jangid_metacu
 * @param <E> , type of Data
 */
public class Stack<E> {
	
	private final int MAX;
	private int top;
	private Object[] stack;

	/**
	 * Initialize Stack Object
	 * @param size int, size of stack
	 */
	Stack(int size){
		this.MAX = size;
		this.top = -1;
		this.stack = new Object[size];
	}

	/**
	 * Method to check if Stack is empty or not
	 * @return boolean, true if Stack is empty otherwise False 
	 */
	public boolean isEmpty(){
		return (this.top < 0);
	}
	
	/**
	 * Method to Push an element into Stack
	 * @param x E, element
	 * @return boolean, true if eleemnt is successfully added
	 * @throws AssertionError if stack is full
	 */
	public boolean push(E x) throws AssertionError{
		if (this.top >= (this.MAX - 1)) {
			throw new AssertionError("Stack Overflow");
		}
		else {
			this.stack[++this.top] = x;
			return true;
		}
	}

	/**
	 * Method to pop element form Stack
	 * @return E, element at last position
	 * @throws AssertionError if stack is Empty
	 */
	public E pop() throws AssertionError{
		if (this.top < 0) {
			throw new AssertionError("Stack Underflow");
		}
		else {
			E x = (E) this.stack[this.top--];
			return x;
		}
	}

	/**
	 * Method to get top element in Stack
	 * @return E, element at Top
	 * @throws AssertionError if Stack is empty
	 */
	public E peek() throws AssertionError
	{
		if (this.top < 0) {
			throw new AssertionError("Stack Underflow");
		}
		else {
			E x = (E) this.stack[this.top];
			return x;
		}
	}
}
