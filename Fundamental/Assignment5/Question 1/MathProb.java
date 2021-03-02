package main;

public class MathProb {

	
	/**
	 * Calculate LCM of Two numbers
	 * @param x , A positive Integer
	 * @param y , A positive Integer
	 * @return , LCM of x & y
	 */
	public int LCM( int x , int y ){
		return (x*y) / HCF(x,y);
	}

	
	/**
	 * Calculate HCF of Two numbers
	 * @param x , A positive Integer
	 * @param y , A positive Integer
	 * @return , HCF of x & y
	 */
	public int HCF ( int x , int y ){
		if( x == 0 ){
			return y ;
		}
		return HCF( y%x , x );
	}
	
	
	
}
