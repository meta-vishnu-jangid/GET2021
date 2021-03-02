package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathProbTest {
	
	MathProb mathProb = new MathProb();
	 
	/**
	 * Test Case for LCM
	 */
    @Test
	public void testLCM() {
    	int lcmResult = mathProb.LCM(3, 6);
	    assertEquals(6, lcmResult);
	}
	
    /**
     * Test Case for HCF
     */
	@Test
	public void testHCF() {
	    int hcfResult = mathProb.HCF(18, 6);
	    assertEquals(6, hcfResult);
	}


}
