package main;
import main.JobSchedular;

public class MainApp {

	public static void printArray( int[] arr){
		for( int element : arr){
			System.out.print( element + " ") ;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[][] processesList = { {0,10},{6,20},{60,10},{110,5}};
	
		JobSchedular jobSchedular1 = new JobSchedular(processesList);
		
		MainApp.printArray(jobSchedular1.getCompletionTimeForEachProcess());
		MainApp.printArray(jobSchedular1.getWaitingTimeForEachProcess());
		MainApp.printArray(jobSchedular1.getTurnAroundTimeForEachProcess());
		
		System.out.println(jobSchedular1.getAverageWaitingTime());
		System.out.println(jobSchedular1.getMaxWaitingTime());
		
	}

}
