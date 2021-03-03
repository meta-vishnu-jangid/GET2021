package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	Search search = new Search();
	
	
	/**
	 * Test Class for testing Linear Search
	 */
	@Test
	 public void testLinearSearch1() {
		
        int indexResult1 = search.linearSearch(new int[]{1, 2, 7, 3, 4, 5}, 0, 2);
        assertEquals(1, indexResult1);
        
        int indexResult2 = search.linearSearch(new int[]{1, 2, 7, 3, 4, 5}, 0, 10);
        assertEquals(-1, indexResult2);
        
        int indexResult3 = search.linearSearch(new int[]{1, 2, 7, 2, 4, 5}, 2, 2);
        assertEquals(3, indexResult3);
    }
	
	/**
	 * Test Class for testing Binary Search
	 */
	@Test
	 public void testBinarySearch1() {
		
       int indexResult1 = search.binarySearch(new int[]{1, 2, 7, 3, 4, 5}, 0,5, 2);
       assertEquals(1, indexResult1);
       
       int indexResult2 = search.binarySearch(new int[]{1, 2, 7, 3, 4, 5}, 0,5, 10);
       assertEquals(-1, indexResult2);
       
       int indexResult3 = search.binarySearch(new int[]{1, 10, 7, 3, 10, 5}, 0,3, 10);
       assertEquals(1, indexResult3);
   }
	
}
