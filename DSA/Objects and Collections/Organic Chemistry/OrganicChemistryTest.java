package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for Organic Chemistry
 * @author vishnu.jangid_metacu
 *
 */
public class OrganicChemistryTest {

	/**
	 * Method to test getMassOfCompound Method of OrganicChemistry Class
	 */
	@Test
	public void test() {
		OrganicChemistry organicChemistry = new OrganicChemistry();
		
		assertEquals(14, organicChemistry.getMassOfCompound("CH2"));
		assertEquals(45, organicChemistry.getMassOfCompound("CHO2"));
		assertEquals(70, organicChemistry.getMassOfCompound("C(cHO)2"));
		assertEquals(48, organicChemistry.getMassOfCompound("C(H2O)2"));
		assertEquals(80, organicChemistry.getMassOfCompound("C(H2O2)2"));
	}
	
	/**
	 * Method to test Exception if '(' is missing
	 */
	@Test(expected=AssertionError.class)
	public void exceptionTest1(){
		OrganicChemistry organicChemistry = new OrganicChemistry();
		assertEquals(14, organicChemistry.getMassOfCompound("CH2)"));
	}
	
	/**
	 * Method to test Exception if ')' is missing
	 */
	@Test(expected=AssertionError.class)
	public void exceptionTest2(){
		OrganicChemistry organicChemistry = new OrganicChemistry();
		assertEquals(13, organicChemistry.getMassOfCompound("C(H2"));
	}
	
	/**
	 * Method to test Exception if formula is null
	 */
	@Test(expected=AssertionError.class)
	public void exceptionTest3(){
		OrganicChemistry organicChemistry = new OrganicChemistry();
		assertEquals(14, organicChemistry.getMassOfCompound(null));
	}
	
	/**
	 * Method to test Exception if formula is empty
	 */
	@Test(expected=AssertionError.class)
	public void exceptionTest4(){
		OrganicChemistry organicChemistry = new OrganicChemistry();
		assertEquals(14, organicChemistry.getMassOfCompound(""));
	}
}
