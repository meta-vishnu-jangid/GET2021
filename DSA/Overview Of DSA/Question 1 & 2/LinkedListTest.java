package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for LinkedList
 * @author vishnu.jangid_metacu
 *
 */
public class LinkedListTest {

	/**
	 * Method to test for Assertion Error in rotateSubList Method  
	 */
	@Test(expected=AssertionError.class)
	public void test1() {
		LinkedList linkedList = new LinkedList();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		linkedList.rotateSubList(2, 4, 2);
	}

	/**
	 * Method to test for Assertion Error in rotateSubList Method  
	 */
	@Test(expected=AssertionError.class)
	public void test2() {
		LinkedList linkedList = new LinkedList();
		
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		
		linkedList.rotateSubList(0, 2, 2);
	}

}
