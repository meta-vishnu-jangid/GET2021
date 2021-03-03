package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class for MathProb Class
 * @author vishnu.jangid_metacu
 *
 */
public class MathOperationTest {
	
	MathOperation mathProb = new MathOperation();
	 
	/**
	 * Test Case for LCM
	 */
    @Test
	public void testLCM() {
    	
    	int lcmResult1 = mathProb.LCM(3, 6);
	    assertEquals(6, lcmResult1);
	    
	    int lcmResult2 = mathProb.LCM(6, 3);
	    assertEquals(6, lcmResult2);
	    
	    int lcmResult3 = mathProb.LCM(3, 3);
	    assertEquals(3, lcmResult3);
	    
	    int lcmResult4 = mathProb.LCM(0, 3);
	    assertEquals(0, lcmResult4);
	    
	}
	
    /**
     * Test Case for HCF
     */
	@Test
	public void testHCF() {
		
	    int hcfResult1 = mathProb.HCF(18, 6);
	    assertEquals(6, hcfResult1);
	    
	    int hcfResult2 = mathProb.HCF(6, 18);
	    assertEquals(6, hcfResult2);
	    
	    int hcfResult3 = mathProb.HCF(18, 18);
	    assertEquals(18, hcfResult3);
	    
	    int hcfResult4 = mathProb.HCF(0, 5);
	    assertEquals(5, hcfResult4);
	}


}
