package main;

public class StringFunc {
	
	
	/**
	 * Method to compare two strings
	 * @param s1  First String ,  requires strings to be not null.
	 * @param S2  Second String ,  requires strings to be not null.
	 * @return 1 if strings are equal otherwise 0.
	 */
	public static int compare( String str1 , String str2 ){
	
		int isStringAreEqual = 1 ; // let 1 for equal and 0 for not equal
		
		if( str1.length() != str1.length() ){ // If Strings Length are not same
			isStringAreEqual = 0; 
		}
		else{
			for( int index = 0 ; index < str1.length() ; index ++ ){
				if( str1.charAt(index) != str2.charAt(index)){
					isStringAreEqual = 0;
					break;
				}
			}
		}
		
		return isStringAreEqual;
		
	}
	
	
	
	/**
	 * Method to get Reverse of a String
	 * @param str , requires string is not null.
	 * @return string which is reverse string of passed string
	 */
	public static String reverse ( String str ){
		
		String reverseString = "";
		
		for( int index = 0 ; index < str.length() ; index++ ){
			reverseString = str.charAt(index) + reverseString ;
		}
		
		return reverseString;
	}
	
	
	
	/**
	 * Method to replace string Lowercase characters with Uppercase and vice-versa. 
	 * @param str , requires string is not null.
	 * @return a String with letter cases swapped.
	 */
	public static String swapCase ( String str ){
		
		String swapCaseString = "";
		
		for( int index = 0 ; index < str.length() ; index++ ){
			if( str.charAt(index) >= 65 && str.charAt(index) <= 90   ){
				char newChar = (char) (str.charAt(index) + 32) ;
				swapCaseString += newChar ;
			}
			else if( str.charAt(index) >= 97 && str.charAt(index) <= 122 ){
				char newChar = (char) (str.charAt(index) - 32) ;
				swapCaseString += newChar ;
			}
			else{
				swapCaseString += str.charAt(index) ;
			}
			
		}
		
		return swapCaseString;
		
		
	}
	
	
	/**
	 * Method to get Largest Word Present in String.
	 * @param str , requires string is not null.
	 * @return the largest word of string , If two words are of same length then return last word.
	 */
	public static String largestWord ( String str ){
		
		String largestWord ="" ; 
		int largestWordLength = 0;
		int wordStartIndex = 0 ;
		
		for(int index = 0 ; index < str.length() ; index++ ){
			if( str.charAt(index) == ' ' || str.charAt(index) == '\n' ){
				int lengthOfWord = index - wordStartIndex ;
				if( lengthOfWord >= largestWordLength ){
					largestWord = str.substring( wordStartIndex, index );
					largestWordLength = lengthOfWord ;
				}
				wordStartIndex = index + 1;
			}
		}
		if( str.length() - wordStartIndex >= largestWordLength   ){
			largestWord = str.substring( wordStartIndex , str.length());
		}
		
		return largestWord;		
	}
	
}
