package main;

import java.util.ArrayList;
import java.util.Iterator;

public class IntSet implements Iterable<Integer> {

	private final ArrayList<Integer> set ;
	private final int universalSetUpperBound = 1000;
	private final int universalSetLowerBound = 1;

	
	/**
	 * Initialize an IntSet by Taking array as input
	 * @param arr , requires value in range 1-1000
	 */
	public IntSet(int[] arr){
		
		ArrayList<Integer> tempSet = new ArrayList<Integer>();
		for( int itemOfArr : arr ){
			boolean isItemAlreadyPresent = false;
			
			for( int itemOfSet : tempSet ){
				if( itemOfArr == itemOfSet ){
					isItemAlreadyPresent = true ;
					break;
				}
			}
			
			if(!isItemAlreadyPresent){
				tempSet.add(itemOfArr);
			}
		}
		this.set = tempSet;
	}
	
	/**
	 * Initialize an IntSet by Taking array as input
	 * @param arr , requires value in range 1-1000
	 */
	public IntSet(Integer[] arr){
		
		ArrayList<Integer> tempSet = new ArrayList<Integer>();
		for( int itemOfArr : arr ){
			boolean isItemAlreadyPresent = false;
			
			for( int itemOfSet : tempSet){
				if( itemOfArr == itemOfSet ){
					isItemAlreadyPresent = true ;
					break;
				}
			}
			
			if(!isItemAlreadyPresent){
				tempSet.add(itemOfArr);
			}
		}
		this.set = tempSet;
	}

	
	
	@Override
	public Iterator<Integer> iterator(){
		ArrayList<Integer> tempList = (ArrayList<Integer>) this.set.clone();
		return tempList.iterator();
	}
	
	
    
    
	/**
	 * check whether x is a member of the set
	 * @param x ,an Integer 
	 * @return , true if X is present, otherwise false
	 */
	public boolean isMember( int x){
		
		for( int itemOfSet : set ){
			if( x == itemOfSet ){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
	 * Method to get size of IntSet
	 * @return size of IntSet
	 */
	public int size(){
		return this.set.size();
	}
	
	
	
	/**
	 * Method to check whether S is a subset of the set
	 * @param S , IntSet 
	 * @return true if S is subset of Set, Otherwise false
	 */
	public boolean hasSubSet( IntSet S ){
		for( int itemInS : S ){
			if( !this.isMember(itemInS)){
				return false;
			}
		}
		return true;
	}
	
	
	
	/**
	 * Method to get Compliment of A set , assuming that 1..1000 is the universal set
	 * @param S , IntSet for which We have to find compliment Set
	 * @return an IntSet object which is Compliment Set of S
	 */
	public IntSet getCompliment(){
		
		int[]  complimentArray = new int[this.universalSetUpperBound - this.universalSetLowerBound + 1 - this.size() ];
		int index = 0 ;
		
		for(int number = this.universalSetLowerBound; number <= this.universalSetUpperBound ; number++ ){
			if( !this.isMember(number)){
				complimentArray[index] = number ;
				index ++ ;
			}
		}
		
		return new IntSet(complimentArray);
	}
	
	
	/**
	 * Method to union another IntSet S with the Set
	 * @param S, IntSet 
	 * @return an IntSet which is union set of two Set. 
	 */
	public IntSet union(IntSet S ){
		
		int[]  complimentArray = new int[ this.size() + S.size()];
		int index = 0 ;
		
		for( int item : this.set ){
			complimentArray[index] = item ;
			index++;
		}
		for( int item : S){
			complimentArray[index] = item ;
			index++;
		}
		return new IntSet(complimentArray);
	}
}
