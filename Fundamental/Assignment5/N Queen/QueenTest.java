package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class for testing NQueen Class Methods
 * @author vishnu.jangid_metacu
 *
 */
public class QueenTest {
	
	NQueen nQueen = new NQueen();

	/**
	 * Method for testing NQueen Method
	 */
	@Test
	public void testNQueen() {
		
		 boolean result1 = nQueen.isPossible(4);
         assertEquals(true, result1);
         
         boolean result2 = nQueen.isPossible(3);
         assertEquals(false, result2);
         
         boolean result3 = nQueen.isPossible(5);
         assertEquals(true, result3);
         
	}

}
