package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class For Testing JDictionary
 * @author vishnu.jangid_metacu
 *
 */
public class JDictionaryTest {
	
	@Test
	public void removeTest() {
		JDictionary dictionary = new JDictionary();
		
		dictionary.add("a", "1");
		dictionary.add("b", "2");
		
		assertEquals(true, dictionary.remove("a"));
		assertEquals(false, dictionary.remove("c"));
	}
	
	/**
	 * Method For Testing Exception in Remove Method
	 */
	@Test(expected = AssertionError.class)
	public void removeExceptionTest() {
		JDictionary dictionary = new JDictionary();
		
		dictionary.remove(null);
	}
	
	/**
	 * Method to test Get Method
	 */
	@Test
	public void getTest(){
		
		JDictionary dictionary = new JDictionary();
		
		dictionary.add("a", "1");
		dictionary.add("b", "2");
		
		assertEquals("1", dictionary.get("a"));
		assertEquals("2", dictionary.get("b"));
	}
	
	/**
	 * Method For Testing Exception in get Method
	 */
	@Test(expected = AssertionError.class)
	public void getExceptionTest() {
		JDictionary dictionary = new JDictionary();
		
		dictionary.get(null);
	}

}
