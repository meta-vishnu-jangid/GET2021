package main;

public class SubTerm {
	public char symbol;
	public int power;
	public SubTerm nextSubTerm;
	
	public SubTerm(char symbol, int power) {
		this.symbol = symbol;
		this.power = power;
		this.nextSubTerm = null;
	}
}
