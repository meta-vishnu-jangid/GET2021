package main;

public class Point {
	
	private double xCoordinate;
	private double yCoordinate;
	
	/**
	 * Constructor to initialize Point Object
	 * @param xCoordinate double, X coordinate of Point
	 * @param yCoordinate double, Y coordinate of Point
	 */
	public Point(double xCoordinate, double yCoordinate){
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	
	/**
	 * Method to get X Coordinate of Point
	 * @return double, X coordinate
	 */
	public double getXCoordinate(){
		return this.xCoordinate;
	}
	
	
	/**
	 * Method to get Y Coordinate of Point
	 * @return double, Y coordinate
	 */
	public double getYCoordinate(){
		return this.yCoordinate;
	}
}
