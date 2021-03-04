package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Square implements Shape {

	private Point origin;
	private double side;
	private String timeStamp;
	
	public Square(Point origin,double side) {
		this.origin = origin;
		this.side = side;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy--MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	
	@Override
	public double getArea() {
		return side*side;
	}

	@Override
	public double getPerimeter() {
		return 4*side;
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
		
		if( xCoordinateOfPoint >= xCoordinateOfOrigin && xCoordinateOfPoint <= xCoordinateOfOrigin + this.side 
				&& yCoordinateOfPoint >= yCoordinateOfOrigin && yCoordinateOfPoint <= yCoordinateOfOrigin + this.side ){
			isPointEnclosed = true ;
		}
		
		return isPointEnclosed;
	}

	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}
	
	@Override
	public String getShapeType() {
		return "Square";
	}

}
