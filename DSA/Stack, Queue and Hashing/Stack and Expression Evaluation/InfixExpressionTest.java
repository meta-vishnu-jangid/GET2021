package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class For Testing InfixExpression Class
 * @author vishnu.jangid_metacu
 *
 */
public class InfixExpressionTest {

	/**
	 * Method to Test infixToPostfixConversion Method
	 */
	@Test
	public void infixToPostfixTest() {
		assertEquals("a b c d * e - * f g h * + * + i -", InfixExpression.infixToPostfix("a + b * ( c * d - e ) * ( f + g * h ) - i"));
		assertEquals("a b c", InfixExpression.infixToPostfix("a b c "));
	}
	
	
	/**
	 * Method to Test Exception in infixToPostfixConversion Method
	 */
	@Test(expected = AssertionError.class)
	public void infixToPostfixExceptionTest1() {
		InfixExpression.infixToPostfix(null);
	}
	
	
	/**
	 * Method to Test evaluateExpression Method
	 */
	@Test
	public void evaluateExpressionTest(){
		assertEquals("true",InfixExpression.evaluateExpression("! ( 1 == 1 + 4 )"));
		assertEquals("false",InfixExpression.evaluateExpression("1 == 1 + 4 "));
		assertEquals("5.0",InfixExpression.evaluateExpression(" 1 + 4 "));
		assertEquals("11.5",InfixExpression.evaluateExpression(" 1 + 2 * 3 / 4 + 5 + 8 - 4"));
	}
	
	/**
	 * Method to Test Exception in evaluateExpression Method
	 */
	@Test(expected= AssertionError.class)
	public void evaluateExpressionExceptionTest1(){
		InfixExpression.evaluateExpression("a b ");
	}
	
	/**
	 * Method to Test Exception in evaluateExpression Method
	 */
	@Test(expected= AssertionError.class)
	public void evaluateExpressionExceptionTest2(){
		InfixExpression.evaluateExpression("( a + b ");
	}
}
