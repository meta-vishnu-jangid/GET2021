package main;

public class PolynomialTerm {
	public int coefficient;
	public SubTerm headSubTerm;
	private SubTerm lastSubTerm; 
	public PolynomialTerm nextPolynomialTerm;
	
	public PolynomialTerm(int coefficient) {
		this.headSubTerm = null;
		this.coefficient = coefficient;
		this.nextPolynomialTerm = null;
		this.lastSubTerm = null;
	}
	
	public void addSubTerm(char symbol, int power){
		SubTerm subTerm = new SubTerm(symbol, power);
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
