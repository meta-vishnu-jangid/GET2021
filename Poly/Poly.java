package main;

import java.util.ArrayList;

/**
 * Class For Representing a Polynomial Object
 * @author vishnu.jangid_metacu
 *
 */
public class Poly {

	private final int[][] expression;
	private final int coefficientIndex = 0 ;
	private final int degreeIndex = 1 ;
	
	
	/**
	 * Initialize a Polynomial Object 
	 * @param arr int[][], requires a 2d array which have coefficient at 0 index and Degree at index 1
	 */
	public Poly(int [][] arr ){
		this.expression = arr.clone() ;
	}
	
	/**
	 * To Print Polynomial
	 */
	@Override
	public String toString(){
		String expression = "" ;
		
		for(int termNo = 0 ; termNo < this.expression.length -1 ; termNo++ ){
			expression = expression + this.expression[termNo][this.coefficientIndex] + "x^" + this.expression[termNo][this.degreeIndex] + " + " ;
		}
		expression = expression + this.expression[this.expression.length-1][this.coefficientIndex] + "x^" + this.expression[this.expression.length-1][this.degreeIndex] ;
		
		return expression;
	}
	
	
	/**
	 * Evaluate a Polynomial Expression
	 * @param number float, Value of X
	 * @return float, A Resultant float value after evaluating expression
	 */
	public float evaluate( float number ){
		
		float answer = 0 ; // Initially take sum as 0
		
		for(int termNo =0 ; termNo < expression.length ; termNo++)
		{
			answer += expression[termNo][this.coefficientIndex]*Math.pow( number, this.expression[termNo][this.degreeIndex]);
		}
			return answer;
	}
	
	
	
	/**
	 * Method to get Degree of a Polynomial
	 * @return int, Degree of Polynomial
	 */
	public int degree(){
		
		int degree = 0  ;
		
		for(int termNo =0 ; termNo < expression.length ; termNo++)
		{
			if ( this.expression[termNo][this.degreeIndex] > degree ){
				degree = this.expression[termNo][this.degreeIndex] ;
			}
		}
		
		return degree ;
	}
	
	/**
	 * Method to get Polynomial
	 * @return
	 */
	private int[][] getPoly(){
		return this.expression.clone(); 
	}
	
	
	
	/**
	 * Method To add Two Polynomial by passing Two Objects
	 * @param p1 Poly, Polynomial 1
	 * @param p2 Poly, Polynomial 2
	 * @return Poly, A Polynomial which is p1+p2
	 */
	public static Poly addPoly ( Poly p1, Poly p2 ){
		
		int[][] p1Expression = p1.getPoly();
		int[][] p2Expression = p2.getPoly();
		int degreeIndex = 1;
		int coefficientIndex = 0 ;
		
		ArrayList<ArrayList<Integer>>  additionList = new ArrayList<ArrayList<Integer>>();
		
		
		for( int[] termOfP1 : p1Expression ){ // For common Terms and P1 Terms
			
			boolean ifTermIsCommon = false ; 
			
			for(int[] termOfP2 : p2Expression){
				if( termOfP1[degreeIndex] == termOfP2[degreeIndex]  ){
					
					ArrayList<Integer> pair = new ArrayList<Integer>();
					pair.add( termOfP1[coefficientIndex] + termOfP2[coefficientIndex] );
					pair.add( termOfP2[degreeIndex] );
					additionList.add(pair);
					ifTermIsCommon = true ;
					break;
				}
			}
			
			if(!ifTermIsCommon){ // If Term is not common add term of P1 into result
				
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add( termOfP1[coefficientIndex]);
				pair.add( termOfP1[degreeIndex] );
				additionList.add(pair);
			}
		}
		
		// There may be some terms which are part of P2 and remained unprocessed
		
        for( int[] termOfP2 : p2Expression ){
			
			boolean ifTermIsCommon = false ; 
			
			for(int[] termOfP1 : p1Expression){
				if( termOfP1[degreeIndex] == termOfP2[degreeIndex]  ){
					ifTermIsCommon = true ;
					break;
				}
			}
			
			if(!ifTermIsCommon){
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add( termOfP2[coefficientIndex]);
				pair.add( termOfP2[degreeIndex] );
				additionList.add(pair);
			}
		}
        
        int[][] additionArray = new int[additionList.size()][2];
        for( int termInResult = 0 ; termInResult < additionList.size() ; termInResult++ ){
        	additionArray[termInResult][coefficientIndex] = additionList.get(termInResult).get(coefficientIndex);
        	additionArray[termInResult][degreeIndex] = additionList.get(termInResult).get(degreeIndex);
        }
        
        return new Poly(additionArray);
	}
	
	
	
	/**
	 * Method To multiply Two Polynomial by passing Two Objects
	 * @param p1 Poly, Polynomial 1
	 * @param p2 Poly, Polynomial 2
	 * @return Poly, A Polynomial which is p1*p2
	 */
	public static Poly multiplyPoly ( Poly p1, Poly p2 ){
		
		int[][] p1Expression = p1.getPoly();
		int[][] p2Expression = p2.getPoly();
		int degreeIndex = 1;
		int coefficientIndex = 0 ;
		
		ArrayList<ArrayList<Integer>>  multiplyResultList = new ArrayList<ArrayList<Integer>>();
		
        for( int[] termOfP1 : p1Expression ){ 
			
			for(int[] termOfP2 : p2Expression){
				
				int resultCoefficient = termOfP1[coefficientIndex] * termOfP2[coefficientIndex];
				int resultDegree = termOfP1[degreeIndex] + termOfP2[degreeIndex]; 
				
				// Check If same degree term is  already present or not
				
				boolean ifSameDegreeTermIsPresent = false;
				
				for(int index = 0 ; index < multiplyResultList.size() ; index++ ){
					// If same degree term is  already present  then add result term to it
					if( multiplyResultList.get(index).get(degreeIndex)== resultDegree ) {
						multiplyResultList.get(index).set(coefficientIndex, multiplyResultList.get(index).get(coefficientIndex) + resultCoefficient );
						ifSameDegreeTermIsPresent = true ;
						break;
					}
				}
				
				// If same degree term is not already present  then add new pair
				if(!ifSameDegreeTermIsPresent){
					ArrayList<Integer> pair = new ArrayList<Integer>();
					pair.add(resultCoefficient);
					pair.add(resultDegree);
					
					multiplyResultList.add(pair);
				}
				
			}
		}
        
        int[][] multiplyResultArray = new int[multiplyResultList.size()][2];
        for( int termInResult = 0 ; termInResult < multiplyResultList.size() ; termInResult++ ){
        	multiplyResultArray[termInResult][coefficientIndex] = multiplyResultList.get(termInResult).get(coefficientIndex);
        	multiplyResultArray[termInResult][degreeIndex] = multiplyResultList.get(termInResult).get(degreeIndex);
        }
        
        return new Poly(multiplyResultArray);
		
	}
	
	
}
