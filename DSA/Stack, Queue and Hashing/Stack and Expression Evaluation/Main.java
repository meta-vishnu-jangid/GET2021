package main;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter expression for Postfix Evaluation : ");
		System.out.println(InfixExpression.evaluateExpression(scanner.nextLine()));
	}
}
