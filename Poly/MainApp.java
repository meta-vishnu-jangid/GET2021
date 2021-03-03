package main;
import main.Poly;

public class MainApp {

	public static void main(String[] args) {
		
		int[][] expression1 = {{1,2},{2,3},{3,5}}; // x^2 + 2x^3 + 3x^4
		int [][] expression2 = {{2,3},{4,5}};
		int [][] expression3 = {{3,4},{5,6}};
		
		Poly polyObj1 = new Poly(expression1);
		Poly polyObj2 = new Poly(expression2);
		Poly polyObj3 = new Poly(expression3);
		
		Poly additionPoly12 = Poly.addPoly( polyObj1 , polyObj2);
		Poly additionPoly13 = Poly.addPoly( polyObj1 , polyObj3);
		Poly additionPoly23 = Poly.addPoly( polyObj3 , polyObj2);
		
		Poly multiplyPoly12 = Poly.multiplyPoly( polyObj1, polyObj2);
		Poly multiplyPoly13 = Poly.multiplyPoly( polyObj1, polyObj3);
		Poly multiplyPoly23 = Poly.multiplyPoly( polyObj3, polyObj2);
		
		
		System.out.println("Polynomial 1 : " + polyObj1);
		System.out.println("\nPolynomial 2 : " + polyObj2);
		System.out.println("\nPolynomial 3 : " + polyObj3);
		
		System.out.println("\nDegree Of Polynomial 1 : " + polyObj1.degree());
		System.out.println("\nDegree Of Polynomial 2 : " + polyObj2.degree());
		System.out.println("\nDegree Of Polynomial 3 : " + polyObj3.degree());
		
		System.out.println("\nValue Of Polynomial 1 when x = 2 : " + polyObj1.evaluate(2));
		System.out.println("\nValue Of Polynomial 2 when x = 0 : " + polyObj2.evaluate(0));
		System.out.println("\nValue Of Polynomial 3 when x = 1 : " + polyObj3.evaluate(1));
		
		System.out.println("\nAddition of Polynomial 1 and Polynomial 2 : " +  additionPoly12);
		System.out.println("\nAddition of Polynomial 1 and Polynomial 3 : " +  additionPoly13);
		System.out.println("\nAddition of Polynomial 2 and Polynomial 3 : " +  additionPoly23);
		
		System.out.println("\nMultiplication of Polynomial 1 and Polynomial 2 : " +  multiplyPoly12);
		System.out.println("\nMultiplication of Polynomial 1 and Polynomial 3 : " +  multiplyPoly13);
		System.out.println("\nMultiplication of Polynomial 2 and Polynomial 3 : " +  multiplyPoly23);
		
				
		

	}

}
