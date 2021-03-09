package main;

/**
 * Class For Representing a Polynomial Term
 * @author vishnu.jangid_metacu
 */
public class PolynomialTerm {
	public int degree;
	public int coefficient;
	public SubTerm headSubTerm;
	private SubTerm lastSubTerm; 
	public PolynomialTerm nextPolynomialTerm;
	
	/**
	 * Initialize a Polynomial Term
	 * @param coefficient int, Coefficient of Term
	 */
	public PolynomialTerm(int coefficient) {
		this.headSubTerm = null;
		this.coefficient = coefficient;
		this.nextPolynomialTerm = null;
		this.lastSubTerm = null;
		this.degree = 0;
	}
	
	/**
	 * Method to add SubTerm to PolynomialTerm
	 * @param symbol char, e.g. x,y,z,w 
	 * @param power int, power of symbol
	 */
	public void addSubTerm(char symbol, int power){
		SubTerm subTerm = new SubTerm(symbol, power);
		this.degree += power;
		if(this.headSubTerm == null){
			this.headSubTerm = subTerm;
			this.lastSubTerm = subTerm;
		}
		else{
			this.lastSubTerm.nextSubTerm = subTerm;
			this.lastSubTerm = subTerm;
		}
	}
}
