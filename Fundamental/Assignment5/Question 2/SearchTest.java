package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {

	 Search search = new Search();
	
	@Test
	 public void testLinearSearch1() {
		
        int indexResult1 = search.linearSearch(new int[]{1, 2, 7, 3, 4, 5}, 0, 2);
        assertEquals(1, indexResult1);
        
        int indexResult2 = search.linearSearch(new int[]{1, 2, 7, 3, 4, 5}, 0, 10);
        assertEquals(-1, indexResult2);
    }
	
	@Test
	 public void testBinarySearch1() {
		
       int indexResult1 = search.binarySearch(new int[]{1, 2, 7, 3, 4, 5}, 0,5, 2);
       assertEquals(1, indexResult1);
       
       int indexResult2 = search.binarySearch(new int[]{1, 2, 7, 3, 4, 5}, 0,5, 10);
       assertEquals(-1, indexResult2);
   }
	
}
