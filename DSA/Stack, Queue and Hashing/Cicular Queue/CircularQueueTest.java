package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for Circular Queue
 * @author vishnu.jangid_metacu
 *
 */
public class CircularQueueTest {

	/**
	 * Method to Test methods of CircularQueue
	 */
	@Test
	public void circularQueueTest() {
		CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);
		
		assertEquals(true, circularQueue.isEmpty());
		assertEquals(false, circularQueue.isFull());
		
		assertEquals(true,circularQueue.enQueue(1));
		
		assertEquals(false, circularQueue.isEmpty());
		
		assertEquals(true,circularQueue.enQueue(2));
		assertEquals(true,circularQueue.enQueue(3));
		assertEquals(true,circularQueue.enQueue(4));
		assertEquals(true,circularQueue.enQueue(5));
		
		assertArrayEquals(new Integer[]{1,2,3,4,5}, circularQueue.getQueue());
		
		assertEquals(true, circularQueue.isFull());
		
		assertEquals((Integer)1,circularQueue.deQueue());
		assertArrayEquals(new Integer[]{2,3,4,5}, circularQueue.getQueue());
		
		assertEquals(true,circularQueue.enQueue(6));
		assertArrayEquals(new Integer[]{2,3,4,5,6}, circularQueue.getQueue());
		
	}
	
	/**
	 * Method to Test exception in Enqueue method
	 */
	@Test(expected= AssertionError.class)
	public void enqueueExceptionTes(){
		
        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(2);
		
		circularQueue.enQueue(1);
		circularQueue.enQueue(1);
		circularQueue.enQueue(1);		
	}
	
	/**
	 * Method to Test Exception in Dequeu method
	 */
	@Test(expected= AssertionError.class)
	public void dequeueExceptionTes(){
		
        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(2);
        circularQueue.deQueue();
	}

}
