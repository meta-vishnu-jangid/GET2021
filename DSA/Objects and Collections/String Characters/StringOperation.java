package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for find unique characters in String
 * @author vishnu.jangid_metacu
 *
 */
public class StringOperation {
	private HashMap<String,Integer> stringMap ;
	
	/**
	 * Constructor
	 */
	public StringOperation() {
		this.stringMap = new HashMap<String, Integer>();
	}
	
	/**
	 * Method to find unique characters in String
	 * @param str String
	 * @return int, number of unique characters in String
	 * @throws AssertionError if string is null
	 */
	public  int getNumberOfUniqueCharacters(String str) throws AssertionError{
		if(str == null){
			throw new AssertionError("String cannot be null");
		}
		int  numberOfUniqueCharaccters = 0;
		
		if( this.stringMap.containsKey(str)){
			return this.stringMap.get(str);
		}
		Set<Character> charSet = new HashSet<Character>();
		for(int index = 0; index < str.length(); index++){
			if(charSet.contains(str.charAt(index))){
				
			}
			else{
				numberOfUniqueCharaccters += 1;
				charSet.add(str.charAt(index));
			}
		}
		this.stringMap.put(str, numberOfUniqueCharaccters);
		return numberOfUniqueCharaccters;
	}
}
