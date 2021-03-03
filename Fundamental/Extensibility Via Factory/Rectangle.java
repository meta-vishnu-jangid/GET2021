package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rectangle implements Shape {
	
	private Point origin;
	private double width;
	private double length;
	private String timeStamp;
	
	public Rectangle(Point origin, double length, double width) {
		this.origin = origin;
		this.width = width;
		this.length = length;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy--MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	
	@Override
	public double getArea() {
		return this.width*this.length;
	}

	@Override
	public double getPerimeter() {
		return 2*(this.width + this.length);
	}

	@Override
	public Point getOrigin() {
		return this.origin;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		
		boolean isPointEnclosed = false;
		double xCoordinateOfPoint = point.getXCoordinate();
		double yCoordinateOfPoint = point.getYCoordinate();
		double yCoordinateOfOrigin = this.origin.getYCoordinate();
		double xCoordinateOfOrigin = this.origin.getXCoordinate();
		
		if( xCoordinateOfPoint >= xCoordinateOfOrigin && xCoordinateOfPoint <= xCoordinateOfOrigin + this.length 
				&& yCoordinateOfPoint >= yCoordinateOfOrigin && yCoordinateOfPoint <= yCoordinateOfOrigin + this.width ){
			isPointEnclosed = true ;
		}
		
		return isPointEnclosed;
	}

	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}
	
}
