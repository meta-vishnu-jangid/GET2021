package main;
import main.Poly;

public class MainApp {

	public static void main(String[] args) {
		
		int[][] expression1 = {{1,2},{2,3},{3,5}}; // x^2 + 2x^3 + 3x^4
		int [][] expression2 = {{2,3},{4,5}};
		
		Poly polyObj1 = new Poly( expression1 );
		Poly polyObj2 = new Poly( expression2 );
		Poly additionPoly = Poly.addPoly( polyObj1 , polyObj2);
		Poly multiplyPoly = Poly.multiplyPoly( polyObj1, polyObj2);
		
		System.out.println("Polynomial 1 : " + polyObj1);
		System.out.println("\nPolynomial 2 : " + polyObj2);
		
		System.out.println("\nDegree Of Polynomial 1 : " + polyObj1.degree());
		System.out.println("\nValue Of Polynomial 1 when x = 2 : " + polyObj1.evaluate(2));
		
		System.out.println("\nAddition of Polynomial 1 and Polynomial 2 : " +  additionPoly);
		System.out.println("\nMultiplication of Polynomial 1 and Polynomial 2 : " +  multiplyPoly);
		
				
		

	}

}
