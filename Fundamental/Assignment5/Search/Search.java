package main;

/**
 * Class designed for different Search Approaches
 * @author vishnu.jangid_metacu
 *
 */
public class Search {

	/**
	 * Searches the element in array using Linear Search
	 * @param arr in[] , Array of Integers requires not null or of Zero length
	 * @param leftIndex int, Index From Left Where search begins
	 * @param value int, Value to Be Search 
	 * @return int, index at which element is present , if not then -1
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
	 * @param arr int[], Array of Integers requires not null or of Zero length
	 * @param leftIndex int, Index From Left Where search begins
	 * @param rightIndex int,Index From Left Where search last 
	 * @param value int, Value to Be Search 
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
