package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for StringOperation Class
 * @author vishnu.jangid_metacu
 *
 */
public class StringOperationTest {

	/**
	 * Method to Test getNumberOfUniqueCharacters Method
	 */
	@Test
	public void test() {
		StringOperation stringOperation =  new StringOperation();
		
		assertEquals(3,stringOperation.getNumberOfUniqueCharacters("abca"));
		assertEquals(3,stringOperation.getNumberOfUniqueCharacters("abca"));
		assertEquals(3,stringOperation.getNumberOfUniqueCharacters("bbca"));
		assertEquals(7,stringOperation.getNumberOfUniqueCharacters("abcdeffhh"));
	}
	
	/**
	 * Method to check Exception in getNumberOfUniqueCharacters Method
	 */
	@Test(expected = AssertionError.class)
	public void exceptionTest() {
		StringOperation stringOperation =  new StringOperation();
		
		assertEquals(3,stringOperation.getNumberOfUniqueCharacters(null));	}

}
