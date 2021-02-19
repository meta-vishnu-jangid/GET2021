package main;

public class JobSchedular {

	private int[][] processesList ;
	private int noOfProcesses = 0  ;
	
	private final int arrivalTimeIndex = 0 ; 
	private final int burstTimeIndex = 1 ;
	
	private final int startingTime = 0 ; 
	
	private Float averageWaitingTime = null ;
	private Integer maxWaitingTime = null ;
	
	
	
	JobSchedular(final int[][] processes){
		this.processesList = processes;
		this.noOfProcesses = processes.length;
	}
	
	
	/**
	 * Method to get Completion Time For Each Process in in Process Queue
	 * @return Array which contains Completion Time For Each Process
	 */
	public int[] getCompletionTimeForEachProcess(){
		
		int timeLapsed = this.startingTime ;
		int[] completionTimeForEachProcess = new int[this.noOfProcesses];
		
		for(int processNo = 0 ; processNo < this.noOfProcesses ; processNo++ ){  // Let proceesNo start from 0
			
			if( this.processesList[processNo][this.arrivalTimeIndex] <= timeLapsed ){ // if process is already there in queue, so it will just start performing
				timeLapsed += this.processesList[processNo][this.burstTimeIndex] ;  
				completionTimeForEachProcess[processNo] = timeLapsed ;
			}
			else{ // If there are no processes in queue, then upcoming process will complete processing in burstTime after Arrival Time 
				timeLapsed = this.processesList[processNo][this.arrivalTimeIndex] + this.processesList[processNo][this.burstTimeIndex] ;
				completionTimeForEachProcess[processNo] = timeLapsed ;
			}
			
		}
		return completionTimeForEachProcess ;
	}
	
	
	/**
	 * Method to get Waiting Time For Each Process in Process Queue
	 * @return Array which contains Waiting Time For Each Process
	 */
    public int[] getWaitingTimeForEachProcess(){
		
    	int timeLapsed = this.startingTime ;
		int[] waitingTimeForEachProcess = new int[this.noOfProcesses];
		int totalWaitingTimeForAllProcesses = 0 ;
		int maxWaitingTime = 0 ;
		
		for(int processNo = 0 ; processNo < this.noOfProcesses ; processNo++ ){  // Let proceesNo start from 0
			
			if( this.processesList[processNo][this.arrivalTimeIndex] <= timeLapsed ){ // if process is already there in queue
				waitingTimeForEachProcess[processNo] = timeLapsed - this.processesList[processNo][this.arrivalTimeIndex] ;
				timeLapsed += this.processesList[processNo][this.burstTimeIndex] ;  			
			}
			
			else{   // If there are no processes in queue , So Process don't have to wait for processing
				timeLapsed = this.processesList[processNo][this.arrivalTimeIndex] + this.processesList[processNo][this.burstTimeIndex] ;
				waitingTimeForEachProcess[processNo] = 0 ;
			}
			
			totalWaitingTimeForAllProcesses += waitingTimeForEachProcess[processNo] ;
			if( waitingTimeForEachProcess[processNo] > maxWaitingTime ){
				maxWaitingTime = waitingTimeForEachProcess[processNo] ;
			}
		}
		
		this.averageWaitingTime = (float)totalWaitingTimeForAllProcesses/this.noOfProcesses;
		this.maxWaitingTime = maxWaitingTime ;
		
		return waitingTimeForEachProcess ;
	}
    
    
    /**
     * Method to get Turn Around Time For Each Process in in Process Queue
     * @return Array which contains Turn Around Time For Each Process
     */
    public int[] getTurnAroundTimeForEachProcess(){
		
    	int[] waitingTimeForEachProcess = this.getWaitingTimeForEachProcess();
		int[] turnAroundTimeForEachProcess = new int[this.noOfProcesses];
		
        for(int processNo = 0 ; processNo < this.noOfProcesses ; processNo++ ){  // Let proceesNo start from 0
        //  Turn Around Time = Waiting Time + Burst Time 
        	turnAroundTimeForEachProcess[processNo] = waitingTimeForEachProcess[processNo] + this.processesList[processNo][this.burstTimeIndex]; 
		}
		return turnAroundTimeForEachProcess ;
	}
	
    
    /**
     * Method to get Average Waiting Time of Process Queue
     * @return Float value representing Average Waiting Time  
     */
    public float getAverageWaitingTime(){
    	
    	if(this.averageWaitingTime == null){
    		this.getWaitingTimeForEachProcess(); // Method will calculate Average Waiting Time Also
    	}
    	return this.averageWaitingTime;
    }
    
    
    /**
     * Method to get Maximum Waiting Time by any Process in queue
     * @return Integer representing max Waiting Time
     */
    public int getMaxWaitingTime(){
    	if(this.maxWaitingTime == null){
    		this.getWaitingTimeForEachProcess(); // Method will calculate Average Waiting Time Also
    	}
    	return this.maxWaitingTime;

    }
	
}
