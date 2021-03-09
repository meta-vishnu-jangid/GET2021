package main;

public class Main {

	public static void main(String[] args) {
		System.out.println(InfixExpression.infixToPostfix("a + b * ( c * d - e * ( f + g * h ) - i"));
		System.out.println(InfixExpression.evaluateExpression("1 + 2 * 3 / 4 + 5 + 8 - 4"));
		System.out.println(InfixExpression.infixToPostfix("! ( 1 == 1 + 4 )"));
		System.out.println(InfixExpression.evaluateExpression("! ( 1 == 1 + 4 )"));
	}

}