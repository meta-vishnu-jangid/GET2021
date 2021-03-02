package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrOperationTest {

	/**
	 * Test Case for maxMirror Method
	 */
	@Test
	public void maxMirrorTest() {
	
		ArrOperation arrOperation = new ArrOperation();
		
		int[] arr1  = {1, 2, 3, 8, 9, 3, 2, 1} ;
		assertEquals(3, arrOperation.maxMirror(arr1) );
		
		int[] arr2  = {7, 1, 4, 9, 7, 4, 1} ;
		assertEquals(2, arrOperation.maxMirror(arr2) );
		
		int[] arr3  = {1, 2, 1, 4} ;
		assertEquals(3, arrOperation.maxMirror(arr3) );
		
		int[] arr4  = {1, 4, 5, 3, 5, 4, 1} ;
		assertEquals(7, arrOperation.maxMirror(arr4) );
	}
	
	/**
	 * Test Cases for count Clums Method
	 */
	@Test
	public void countClumpsTest(){
		
		ArrOperation arrOperation = new ArrOperation();
		
		int[] arr1 = {1, 2, 2, 3, 4, 4};
		assertEquals(2, arrOperation.countClumps(arr1));
		
		int[] arr2 = {1, 1, 2, 1, 1};
		assertEquals(2, arrOperation.countClumps(arr2));
		
		int[] arr3 = {1,1,1,1,1};
		assertEquals(1, arrOperation.countClumps(arr3));

	}
	
	/**
	 * Test Cases For FixXY Method
	 */
	@Test
	public void fixXYTest(){
	
		ArrOperation arrOperation = new ArrOperation();
		
		int[] arr1 = {5, 4, 9, 4, 9, 5};
		int[] arr1FixXYActualResult = {9, 4, 5, 4, 5, 9};
		assertArrayEquals(arr1FixXYActualResult,arrOperation.fixXY(arr1, 4, 5));
		
		int[] arr2 = {1, 4, 1, 5};
		int[] arr2FixXYActualResult = {1, 4, 5, 1};
		assertArrayEquals(arr2FixXYActualResult,arrOperation.fixXY(arr2, 4, 5));
		
		int[] arr3 = {1, 4, 1, 5, 5, 4, 1};
		int[] arr3FixXYActualResult = {1, 4, 5, 1, 1, 4, 5};
		assertArrayEquals(arr3FixXYActualResult,arrOperation.fixXY(arr3, 4, 5));
	}
	
	/**
	 * Test Cases For splitArray Method
	 */
	@Test
	public void splitArrayTest(){
	
		ArrOperation arrOperation = new ArrOperation();
		
		int[] arr1 = {1, 1, 1, 2, 1};
		assertEquals(3, arrOperation.splitArray(arr1));
		
		int[] arr2 = {2, 1, 1, 2, 1};
		assertEquals(-1, arrOperation.splitArray(arr2));
		
		int[] arr3 = {10,10};
		assertEquals(1, arrOperation.splitArray(arr3));
	}
	
	/**
	 * Test Case for CountClumps Method for Empty Array Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestCountClumps(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 = {} ;
		arrOperation.countClumps(arr1);
	
	}
	
	/**
	 * Test Case for maxMirror Method for Empty Array Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestMaxMirror(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 = {} ;
		arrOperation.maxMirror(arr1);
	}
	
	/**
	 * Test Case for fixXY Method for Empty Array Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestFixXY(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 = {} ;
		arrOperation.fixXY(arr1, 4, 5);
	}
	
	/**
	 * Test Case for splitArray Method for Empty Array Exception
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestSplitArray(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 = {} ;
		arrOperation.splitArray(arr1);
	}
	
	/**
	 * Test Case for fixXY Method for Unequal Numbers of X & Y
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestFixXY2(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 = {1,4,1,5,3,4,1} ;
		arrOperation.fixXY(arr1, 4, 5);
	}
	
	
	
	/**
	 * Test Case for fixXY Method for X at Last Position
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestFixXY3(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 =  {1,4,1,5,3,5,4}  ;
		arrOperation.fixXY(arr1, 4, 5);
	}
	
	/**
	 * Test Case for fixXY Method for two adjacent X
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTestFixXY4(){
		
		ArrOperation arrOperation = new ArrOperation();
		int[] arr1 =  {1,4,4,5,3,5,1} ; ;
		arrOperation.fixXY(arr1, 4, 5);
	}

}
