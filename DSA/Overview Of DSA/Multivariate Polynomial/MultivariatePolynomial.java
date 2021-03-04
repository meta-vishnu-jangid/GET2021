package main;

/**
 * Class for Multivariate Polynomial
 * @author vishnu.jangid_metacu
 *
 */
public class MultivariatePolynomial {
	
	private PolynomialTerm headPolynomialTerm;
	private PolynomialTerm lastPolynomialTerm;
	
	/**
	 * Initialize Multivariate Polynomial
	 */
	public MultivariatePolynomial() {
		this.headPolynomialTerm = null;
		this.lastPolynomialTerm = null;
	}
	
	/**
	 * Add Polynomial Term into Polynomial Expression
	 * @param coefficient int, Coefficient of Term
	 * @return PolynomialTerm, Object of PolynomialTerm
	 */
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
	
	/**
	 * Method to get Degree of Polynomial 
	 * @return int, degree
	 */
	public int getDegree(){
	    int degree = 0;
		PolynomialTerm startPolynomialTerm = this.headPolynomialTerm;
		while(startPolynomialTerm!=null){
			SubTerm startSubTerm = startPolynomialTerm.headSubTerm;
			int power = 0 ;
			while(startSubTerm!=null){
				power += startSubTerm.power;
				startSubTerm = startSubTerm.nextSubTerm;
			}
			if(power>degree){
				degree = power;
			}
			startPolynomialTerm = startPolynomialTerm.nextPolynomialTerm;
		}
		return degree;
	}
}
