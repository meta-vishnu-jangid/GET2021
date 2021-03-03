package main;

/**
 * This class used for LCM and HCF Calculations
 * @author vishnu.jangid_metacu
 *
 */
public class MathOperation {

	
	/**
	 * Calculate LCM of Two numbers
	 * @param x int, A positive Integer
	 * @param y int, A positive Integer
	 * @return int, LCM of x & y
	 */
	public int LCM( int x , int y ){
		return (x*y) / HCF(x,y);
	}

	
	/**
	 * Calculate HCF of Two numbers
	 * @param x int, A positive Integer
	 * @param y int, A positive Integer
	 * @return int, HCF of x & y
	 */
	public int HCF ( int x , int y ){
		if( x == 0 ){
			return y ;
		}
		return HCF( y%x , x );
	}
	
	
	
}
