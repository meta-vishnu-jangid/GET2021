package main;

public interface Shape {

	enum ShapeType {
		Square,
		Circle,
		Rectangle
	}
	
	/**
	 * Get Area of Shape
	 * @return double , Area of Shape
	 */
	public double getArea();
	
	
	/**
	 * Get Perimeter of Shape
	 * @return double , Perimeter of Shape
	 */
	public double getPerimeter();
	
	
	/**
	 * Get Point of Origin of A Shape
	 * @return Point, Point Object which represents Point of Origin
	 */
	public Point getOrigin();
	
	
	/**
	 * Method to Find if Point lies inside shape or not
	 * @param point Point, A Point Object
	 * @return boolean, true if point lies inside Shape otherwise False
	 */
	public boolean isPointEnclosed(Point point);
	
	/**
	 * Method to get Timestamp at which object is created
	 * @return String, Representing Timestamp
	 */
	public String getTimeStamp();
}
