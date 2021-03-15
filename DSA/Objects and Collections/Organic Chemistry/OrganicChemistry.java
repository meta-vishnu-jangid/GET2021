package main;

import java.util.Stack;

/**
 * Class For Methods used in Organic Chemistry
 * @author vishnu.jangid_metacu
 *
 */
public class OrganicChemistry {
	
	private final int massOfO = 16;
	private final int massOfH = 1;
	private final int massOfC = 12;
	
	/**
	 * @param formula String, chemical formula
	 * @return int, mass of the given chemical Formula
	 */
	public int getMassOfCompound(String formula) throws AssertionError{
		
		Stack<Integer> stack = new Stack<Integer>();
		
		if(formula == null || formula.length() == 0){
			throw new AssertionError("Invalid Input");
		}
		
		formula = formula.toUpperCase();
		int sumInBracket = 0;
		int totalMass = 0;
		
		for(int index = 0 ; index < formula.length(); index++){
			if(formula.charAt(index) == 'C'){
				stack.push(this.massOfC);
			}
			else if(formula.charAt(index) == 'O'){
				stack.push(this.massOfO);
			}
			else if(formula.charAt(index) == 'H'){
				stack.push(this.massOfH);
			}
			else if(formula.charAt(index) == '('){
				stack.push(-1);
			}
			else if(formula.charAt(index) == ')'){
				if(stack.isEmpty()){
					throw new AssertionError("Invalid Input");
				}
				sumInBracket = 0;
				
				while(stack.peek() != -1){
					sumInBracket = sumInBracket + stack.pop();
					if(stack.isEmpty()){
						throw new AssertionError("Invalid Input");
					}
				}
				stack.pop();
				stack.push(sumInBracket);
			}
			else if(formula.charAt(index) <= '9' && formula.charAt(index) >= '0'){
				String number = "" + formula.charAt(index);
				int j = index + 1;
				while(j < formula.length()){
					if(formula.charAt(j)=='C' || formula.charAt(j)=='O' 
						|| formula.charAt(j)=='H' || formula.charAt(j) == '('
						|| formula.charAt(j) == ')'){
						break;
					}
					number = number + formula.charAt(j);
					j++;
				}
				int massMultiplier = Integer.parseInt(number);
				int totalMassCurrentElement = stack.pop()*massMultiplier;
				stack.push(totalMassCurrentElement);
			}
			else {
				throw new AssertionError("Invalid Formula");
			}
		}
		while(!stack.isEmpty()){
			int tempSum = stack.pop();
			if(tempSum == -1){
				throw new AssertionError("Invalid Input");
			}
			totalMass = totalMass + tempSum;
		}
		return totalMass;
	}
}
