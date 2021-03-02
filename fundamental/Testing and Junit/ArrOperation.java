package main;

/**
 * This class perform Operation on Integer Array 
 * @author vishnu.jangid@metacube.com
 *
 */
public class ArrOperation {

	
	/**
	 * Method to find the size of the largest mirror section found in the input array.
	 * @param arr  int[] , Array 
	 * @return int , the size of the largest mirror section found in the input array.
	 * @throws AssertionError if Array is Empty
	 */
	public int maxMirror(int[] arr) throws AssertionError{

		if(arr.length == 0 ){
			throw new AssertionError("Empty Array") ;
		}
		else{
			int maxSizeOfMirror = 0;
			for(int index = 0; index < arr.length; index++){
				int sizeOfMirror = 0;
				for(int indexFromRight = arr.length - 1; indexFromRight >= 0 && index <= indexFromRight; indexFromRight-- ){
					if( arr[index + sizeOfMirror] == arr[indexFromRight]){
						sizeOfMirror ++ ;
					}
					else{
						if(sizeOfMirror > maxSizeOfMirror ){
							maxSizeOfMirror = sizeOfMirror;
						}
						sizeOfMirror = 0 ;
					}
				}
				if(sizeOfMirror > maxSizeOfMirror ){
					maxSizeOfMirror = sizeOfMirror;
				}
			}
			return maxSizeOfMirror ;
		}
	}
	
	
	/**
	 * Method to find number of clumps in array.Clump in an array is a series of 2 or more adjacent elements of the same value.
	 * @param arr in[] , Integer Array
	 * @return int , Number of Clumps
	 * @throws AssertionError if Array is Empty
	 */
	public int countClumps(int[] arr)throws AssertionError{
		
		if(arr.length == 0 ){
			throw new AssertionError("Empty Array") ;
		}
		else{
			int numberOfClumps = 0 ;
			int presentElement = arr[0] ;
			int presentElementCount = 1;
			for(int index = 1; index < arr.length; index++){
				if (arr[index] == presentElement){
					presentElementCount++;
				}
				else{
					presentElement = arr[index];
					presentElementCount = 1;
				}
				if(presentElementCount == 2){
					numberOfClumps++;
				}
			}
			return numberOfClumps;
		}
	}
	
	
	/**
	 * Find an array that contains exactly the same numbers as the input array,
	 * but rearranged so that every X is immediately followed by a Y.
	 * @param arr int[] , Input Array
	 * @param X int , value of X
	 * @param Y int , value of Y
	 * @return int[] , Required Array after rearrangement
	 * @throws AssertionError if Array is Empty or If there are unequal numbers of X and Y in the input array.
	 * or If two adjacents X values are there , If X occurs at the last index of the array.
	 */
	public int[] fixXY(int[] arr, int X, int Y) throws AssertionError{
		
		if(arr.length == 0 || arr[arr.length-1] == X){
			throw new AssertionError("Empty Array") ;
		}
		for(int indexOfX = 0 ; indexOfX < arr.length - 1 ; indexOfX++){
			if(arr[indexOfX] == X && arr[indexOfX + 1] != Y ){
				if(arr[indexOfX + 1] == X){
					throw new AssertionError("Adjacent X found") ;
				}
				else if ( indexOfX + 1 == arr.length ){
					throw new AssertionError("Last Element is X") ;
				}
				else{
					boolean isYFound = false ;
					for( int indexOfY = 0 ; indexOfY < arr.length ; indexOfY ++ ){
						if( arr[indexOfY] == Y && (indexOfY == 0 || arr[indexOfY-1]!=X ) ){
							isYFound = true ;
							int temp = arr[indexOfX + 1];
							arr[indexOfX + 1] = arr[indexOfY];
							arr[indexOfY] = temp;
						}
					}
					if(!isYFound){
						throw new AssertionError("Unequal Number") ;
					}
				}
			}
		}
		return arr;
	}
	
	/**
	 * Method to check if array can be splitted into two parts where sum of both parts is equal.
	 * @param arr int[] , Input Array
	 * @return int , index from which it can be seperated if not -1
	 * @throws AssertionError if Array is Empty
	 */
	public int splitArray(int[] arr) throws AssertionError{
		if(arr.length == 0){
			throw new AssertionError("Empty Array") ;
		}
		for(int index = 1; index < arr.length; index++){
			if( this.sumOfArray(arr, 0, index - 1) == this.sumOfArray(arr, index, arr.length-1) ){
				return index;
			}
		}
		return -1;
	}
	
	/**
	 * Method to calculate sum of array between two indexes
	 * @param arr int[] , input array
	 * @param start int , Starting index
	 * @param end int , End index
	 * @return int , sum
	 */
	private int sumOfArray(int[] arr ,int start ,int end){
		int sum = 0;
		for(int index = start; index <= end; index++){
			sum += arr[index];
		}
		return sum;
	}
	
}
