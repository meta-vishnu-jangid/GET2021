package main;

/**
 * Class for Job
 * @author vishnu.jangid_metacu
 *
 */
public class Job {

	final int value;
	final int priority;
	
	/**
	 * Initialize Job 
	 * @param value int
	 * @param priority int
	 */
	public Job(int value, int priority) {
		
		this.value = value;
		this.priority = priority;
	}

	/**
	 * Get value
	 * @return int, value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * get Priority
	 * @return int, priority value
	 */
	public int getPriority() {
		return priority;
	}
	
	
}