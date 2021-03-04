package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Circle implements Shape{
	
	private double radius;
	private Point origin;
	private String timeStamp;
	
	public Circle(Point origin,double radius) {
		this.origin = origin;
		this.radius = radius;
		this.timeStamp = DateTimeFormatter.ofPattern("yyyy--MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
	
	@Override
	public double getArea(){
		return 22/7*this.radius*this.radius;
	}
	
	@Override
	public double getPerimeter(){
		return 2*22/7*this.radius; 
	}
	
	@Override
	public Point getOrigin(){
		return this.origin;
				
	}
	

	@Override
	public boolean isPointEnclosed(Point point) {
		
		boolean isPointEnclosed = false;
		double xCoordinateOfPoint = point.getXCoordinate();
		double yCoordinateOfPoint = point.getYCoordinate();
		double yCoordinateOfCentre = this.origin.getYCoordinate();
		double xCoordinateOfCentre = this.origin.getXCoordinate();
		double distanceOfPointFromCentre = Math.sqrt(Math.pow(xCoordinateOfPoint - xCoordinateOfCentre, 2)
				+ Math.pow(yCoordinateOfCentre - yCoordinateOfPoint, 2));
		
		if(distanceOfPointFromCentre <= this.radius){
			isPointEnclosed = true;
		}
		return isPointEnclosed;
	}

	@Override
	public String getTimeStamp() {
		return this.timeStamp;
	}

	@Override
	public String getShapeType() {
		return "Circle";
	}
}
