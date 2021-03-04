package main;

public class MultivariatePolynomial {
	
	private PolynomialTerm headPolynomialTerm;
	private PolynomialTerm lastPolynomialTerm;
	
	public MultivariatePolynomial() {
		this.headPolynomialTerm = null;
		this.lastPolynomialTerm = null;
	}
	
	public PolynomialTerm addPolynomialTerm(int coefficient){
		PolynomialTerm polynomialTerm = new PolynomialTerm(coefficient);
		if(this.headPolynomialTerm == null){
			this.headPolynomialTerm = polynomialTerm;
			this.lastPolynomialTerm = polynomialTerm;
		}
		else{
			this.lastPolynomialTerm.nextPolynomialTerm = polynomialTerm;
			this.lastPolynomialTerm = polynomialTerm;
		}
		return polynomialTerm;
	}
	
	public int getDegree(){
	    int degree = 0;
		PolynomialTerm startPolynomialTerm = this.headPolynomialTerm;
		while(startPolynomialTerm!=null){
			
		}
	}
}
