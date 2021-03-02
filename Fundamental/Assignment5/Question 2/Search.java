package main;

public class Search {

	/**
	 * Searches the element in array using Linear Search
	 * @param arr , Array of Integers requires not null or of Zero length
	 * @param leftIndex , Index From Left Where search begins
	 * @param value , Value to Be Search 
	 * @return index at which element is present , if not then -1
	 */
	public int linearSearch( int[] arr , int leftIndex , int value ){
		if(arr.length == leftIndex){
			return -1; // Element not found
 		}
		else if ( arr[leftIndex] == value ){
			return leftIndex;
		}
		else{
			return linearSearch(arr, leftIndex +1 , value);
		}
	}
	
	/**
	* Searches the element in array using Binary Search
	 * @param arr , Array of Integers requires not null or of Zero length
	 * @param leftIndex , Index From Left Where search begins
	 * @param rightIndex ,Index From Left Where search last 
	 * @param value , Value to Be Search 
	 * @return index at which element is present , if not then -1
	 */
	public int binarySearch(int[] arr, int leftIndex, int rightIndex, int value)
	{
		
		if (leftIndex > rightIndex)
			return -1; //element not found
		
		int mid = (leftIndex + rightIndex) / 2;
		
		if (arr[mid] == value)
		    return mid;
		else if (arr[mid] > value)
			return binarySearch(arr, 0, mid - 1, value);
		else
			return binarySearch(arr, mid + 1, rightIndex, value);
	}
}
