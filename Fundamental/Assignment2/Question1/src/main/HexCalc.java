package main;

import java.util.Dictionary;
import java.util.Hashtable;

public class HexCalc {

	private static int base = 16;
	private static String hexDigits = "0123456789ABCDEF" ; 
	
	/**
	 * Function To Convert Hexadecimal Number To Decimal Number
	 * @param hexValue , requires a positive Hexadecimal Number in Form of String
	 * @return an Integer the Decimal Representation of Hexadecimal Number
	 */
	public static int HexToDecimal(String hexValue){
		
		int decimalValue = 0;
		hexValue = hexValue.toUpperCase();
		
		for( int index = 0 ; index < hexValue.length() ; index ++ ){	
			char hexDigit = hexValue.charAt(index);
			int decimalOfHexDigit = hexDigits.indexOf(hexDigit);
			decimalValue = base*decimalValue + decimalOfHexDigit ;	
		}
		
		return decimalValue;
	}
	
    public static int HexToDecimal2(String hexValue){
		
		int decimalValue = 0;
		hexValue = hexValue.toUpperCase();
		
		for( int index = hexValue.length()-1 ; index >= 0 ; index -- ){	
			char hexDigit = hexValue.charAt(index);
			int decimalOfHexDigit = hexDigits.indexOf(hexDigit);
			decimalValue = (int)Math.pow(base, hexValue.length() - index -1)*decimalOfHexDigit + decimalValue ;	
		}
		
		return decimalValue;
	}
	
	/**
	 * Function To Convert Decimal Number To HexaDecimal Number
	 * @param decimalValue , requires a positive decimal number
	 * @return String Hexadecimal Representation of Decimal Number 
	 */
	public static String DecimalToHex(final int decimalValue){
		
		String hexValue = "";
		int decimalVal = decimalValue;
		
		
		while( decimalVal > 0 ){
			
			int remainder = decimalVal % base ;
			hexValue = hexDigits.charAt(remainder) + hexValue ;
			decimalVal = decimalVal/base;
		}
			
		return hexValue;
	}
	
	/**
	 * Method to Add Two HexaDecimal Number
	 * @param hexNumber1 , requires positive value
	 * @param hexNumber2 , requires positive value
	 * @return String Representation of result hex Number
	 */
	public static String add(final String hexNumber1, final String hexNumber2 ){
		return HexCalc.DecimalToHex( HexCalc.HexToDecimal(hexNumber1) + HexCalc.HexToDecimal(hexNumber2) );
	}
	
	/**
	 * Method to Subtract One HexaDecimal Number from another
	 * @param hexNumber1 , Number from which another number will subtracted 
	 * @param hexNumber2 , Number to be subtracted 
	 * @return result
	 */
	public static String subtract(final String hexNumber1, final String hexNumber2 ){
		return HexCalc.DecimalToHex( HexCalc.HexToDecimal(hexNumber1) - HexCalc.HexToDecimal(hexNumber2) );
	}
	
	
	/**
	 * Method to multiply two hexadecimal number
	 * @param hexNumber1 
	 * @param hexNumber2
	 * @return multiplication of two number
	 */
	public static String multiply(final String hexNumber1, final String hexNumber2 ){
		return HexCalc.DecimalToHex( HexCalc.HexToDecimal(hexNumber1) * HexCalc.HexToDecimal(hexNumber2) );
	}
	
	/**
	 * Method to divide One HexaDecimal Number from another
	 * @param hexNumber1 , dividend
	 * @param hexNumber2 , divisor
	 * @return
	 */
	public static String divide(final String hexNumber1, final String hexNumber2 ){
		return HexCalc.DecimalToHex( HexCalc.HexToDecimal(hexNumber1) / HexCalc.HexToDecimal(hexNumber2) );
	}
	
	/**
	 * Method to check if two hexadecimal numbers are equal or not
	 * @param hexNumber1
	 * @param hexNumber2
	 * @return true if numbers are equal otherwise false
	 */
	public static boolean equal(final String hexNumber1, final String hexNumber2 ){
		return hexNumber1.toUpperCase().equals(hexNumber2.toUpperCase());
	}
	
	
	/**
	 * Method to check if Hexadecimal number is greaterThan other hexaDecimal number or not
	 * @param hexNumber1
	 * @param hexNumber2
	 * @return true if Number is greater otherwise false
	 */
	public static boolean greaterThan(final String hexNumber1, final String hexNumber2 ){
		
		int hexNumber1Length = hexNumber1.length();
		int hexNumber2Length = hexNumber2.length();
		
		if(hexNumber1Length == hexNumber2Length){
			for( int index=0 ; index < hexNumber1Length ; index++ ){
				if( hexNumber1.charAt(index)> hexNumber2.charAt(index)) {
					return true;
				}
				else if( hexNumber1.charAt(index)< hexNumber2.charAt(index) ){
					return false;
				}
			}
		}
		else if(hexNumber1Length > hexNumber2Length ){
			return true;
		}
		else{
			return false;
		}
		
		return false;
	}
	
	
	/**
	 *  Method to check if Hexadecimal number is lessThan other hexaDecimal number or not
	 * @param hexNumber1
	 * @param hexNumber2
	 * @return true if Number is less otherwise false
	 */
public static boolean lessThan(final String hexNumber1, final String hexNumber2 ){
		
		int hexNumber1Length = hexNumber1.length();
		int hexNumber2Length = hexNumber2.length();
		
		if(hexNumber1Length == hexNumber2Length){
			for( int index=0 ; index < hexNumber1Length ; index++ ){
				if( hexNumber1.charAt(index)< hexNumber2.charAt(index)) {
					return true;
				}
				else if( hexNumber1.charAt(index)> hexNumber2.charAt(index) ){
					return false;
				}
			}
		}
		else if(hexNumber1Length < hexNumber2Length ){
			return true;
		}
		else{
			return false;
		}
		
		return false;
	}
	
	
	
}
