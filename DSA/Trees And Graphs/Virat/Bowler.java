package main;

/**
 * Class for representing Bowler
 * @author vishnu.jangid_metacu
 */
public class Bowler {
	private int id ;
	private int noOfBalls;
	private static int idCount = 0;
	
	/**
	 * Initialize Bowler
	 * @param noOfBalls int, number of balls left for bowler
	 */
	public Bowler(int noOfBalls){
		this.noOfBalls = noOfBalls;
		this.idCount ++;
		this.id = this.idCount;
	}
	
	/**
	 * Get ID of Bowler
	 * @return int, id 
	 */
	public int getId(){
		return this.id;
	}
	
	/**
	 * Get number of balls left for a bowler
	 * @return int, number of Balls left
	 */
	public int getNoOfBallsLeft(){
		return this.noOfBalls;
	}
}
