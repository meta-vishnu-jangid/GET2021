package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {
	
	NQueen nQueen = new NQueen();

	@Test
	public void testNQueen() {
		
		 boolean result1 = nQueen.isPossible(4);
         assertEquals(true, result1);
         
         boolean result2 = nQueen.isPossible(3);
         assertEquals(false, result2);
         
	}

}
