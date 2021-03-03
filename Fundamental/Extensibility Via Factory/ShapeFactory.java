package main;

public class ShapeFactory {

	public static Shape createShape(String shapeType, Point origin, int[] shapeParameters) throws AssertionError{
		if(shapeType == null){
			throw new AssertionError("ShapeType Cannot be null");
		}
		Shape shape = null;
		
		switch(shapeType){
			case "Square":
				shape = new Square(origin,shapeParameters[0]);
				break;
			case "Rectangle":
				shape = new Rectangle(origin, shapeParameters[0], shapeParameters[1]);
				break;
			case "Circle":
				shape = new Circle(origin,shapeParameters[0]);
				break;
			default:
				throw new AssertionError("ShapeType Not Supported");
		}
		
		return shape;
	}
}
