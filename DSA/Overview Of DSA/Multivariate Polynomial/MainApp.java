package main;

public class MainApp {

	public static void main(String[] args) {
		
		MultivariatePolynomial multivariatePolynomial = new MultivariatePolynomial();
		
		PolynomialTerm polyNomialTerm1 = multivariatePolynomial.addPolynomialTerm(3);
		polyNomialTerm1.addSubTerm('x', 2);
		polyNomialTerm1.addSubTerm('y', 9);
		polyNomialTerm1.addSubTerm('z', 1);
		
		PolynomialTerm polyNomialTerm2 = multivariatePolynomial.addPolynomialTerm(4);
		polyNomialTerm2.addSubTerm('x', 2);
		polyNomialTerm2.addSubTerm('z', 2);
		polyNomialTerm2.addSubTerm('y',3);
		
		System.out.println(multivariatePolynomial.getDegree());
	}

}
