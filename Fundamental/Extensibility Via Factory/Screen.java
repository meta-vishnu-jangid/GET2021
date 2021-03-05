package main;

import java.util.ArrayList;
import java.util.List;

import main.Shape;

public class Screen {
	
	private int xOrigin ;
	private int yOrigin ;
	private List<Shape> listOfShapes = new ArrayList<Shape>(); 
	
	/**
	 * Initialize Screen Object
	 */
	public Screen(){
		this.xOrigin = 0;
		this.yOrigin = 0;
	}
	
	
	/**
	 * Add Shape into Screen
	 * @param shape Shape, shape to be Added
	 * @return boolean, true if successfully added otherwise false
	 * @throws AssertionError if Shape is null
	 */
	public boolean addShape(Shape shape) throws AssertionError{
		if(shape == null){
			throw new AssertionError("Shape Value cannot be null");
		}
		this.listOfShapes.add(shape);
		return true;
	}
	
	
	/**
	 * Delete Shape from Screen
	 * @param shape Shape, Shape to be deleted 
	 * @return boolean, true if successfully deleted or false if not found
	 * @throws AssertionError if shape is null
	 */
	public boolean deleteShape(Shape shape) throws AssertionError{
		if(shape == null){
			throw new AssertionError("Shape Value cannot be null");
		}
		return this.listOfShapes.remove(shape);
	}
	
	
	/**
	 * Delete Shape of Specific Type
	 * @param type String, type of Shape
	 * @return boolean ,true if successfully deleted or false if not found
	 * @throws AssertionError
	 */
	public boolean deleteShapesOfSpecificType(String type) throws AssertionError{
		boolean flag = false;
		if(type == null){
			throw new AssertionError("Type Value cannot be null");
		}
		boolean isShapeFound = false;
		do{
			isShapeFound = false;
			for(Shape shape : listOfShapes){
				if(type.equals(shape.getShapeType())){
				flag = true;
				isShapeFound = true;
				this.listOfShapes.remove(shape);
				break;
			    }
		    }
	    }while(isShapeFound);
		return flag;
	}
	
	
	/**
	 * Method to get Shapes sorted by area
	 * @return Shape[], Array of Shapes
	 */
	public Shape[] getShapesSortedByArea(){
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int i = 0; i < shapeArray.length - 1; i++ ){
			for(int j = 0 ; j < shapeArray.length-i-1; j++){
				if(shapeArray[j].getArea() > shapeArray[j+1].getArea() ){
					Shape tempShape = shapeArray[j];
					shapeArray[j] = shapeArray[j+1];
					shapeArray[j+1] = tempShape;
				}
			}
		}
		for(Shape shape : shapeArray){
			System.out.println(shape.getShapeType());
		}
		return shapeArray;
	}
	
	
	/**
	 * Method to get Shapes sorted by Perimeter
	 * @return Shape[], Array of Shapes
	 */
	public Shape[] getShapesSortedByPerimeter(){
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int i = 0; i < shapeArray.length - 1; i++ ){
			for(int j = 0 ; j < shapeArray.length-i-1; j++){
				if(shapeArray[j].getPerimeter() > shapeArray[j+1].getPerimeter() ){
					Shape tempShape = shapeArray[j];
					shapeArray[j] = shapeArray[j+1];
					shapeArray[j+1] = tempShape;
				}
			}
		}
		
		return shapeArray;
	}
	
	
	/**
	 * Method to get Shapes sorted by origin distance
	 * @return Shape[], Array of Shapes
	 */
	public Shape[] getShapesSortedByOriginDistance(){
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int i = 0; i < shapeArray.length - 1; i++ ){
			for(int j = 0 ; j < shapeArray.length-i-1; j++){
				double distanceFromOrigin1 = Math.sqrt(Math.pow(shapeArray[j].getOrigin().getXCoordinate() - this.xOrigin, 2)
						+ Math.pow(shapeArray[j].getOrigin().getYCoordinate()- this.yOrigin, 2));
				double distanceFromOrigin2 = Math.sqrt(Math.pow(shapeArray[j+1].getOrigin().getXCoordinate() - this.xOrigin, 2)
						+ Math.pow(shapeArray[j+1].getOrigin().getYCoordinate()- this.yOrigin, 2));
				if( distanceFromOrigin1 > distanceFromOrigin2){
					Shape tempShape = shapeArray[j];
					shapeArray[j] = shapeArray[j+1];
					shapeArray[j+1] = tempShape;
				}
			}
		}
		
		return shapeArray;
	}
	
	
	/**
	 * Method to get Shapes sorted by timestamp
	 * @return Shape[], Array of Shapes
	 */
	public Shape[] getShapesSortedByTimeStamp(){
		
		Shape[] shapeArray = this.listOfShapes.toArray(new Shape[this.listOfShapes.size()]);
		for(int i = 0; i < shapeArray.length - 1; i++ ){
			for(int j = 0 ; j < shapeArray.length-i-1; j++){
				if(shapeArray[j].getTimeStamp().compareTo(shapeArray[j+1].getTimeStamp()) > 0 ){
					Shape tempShape = shapeArray[j];
					shapeArray[j] = shapeArray[j+1];
					shapeArray[j+1] = tempShape;
				}
			}
		}
		
		return shapeArray;
	}
	
	/**
	 * Method to get Shapes that enclose a Specific Point
	 * @param point Point, specific Point to check for
	 * @return Shape[], Array of Shapes
	 * @throws AssertionError, if point is null
	 */
	public Shape[] getShapesEnclosingAPoint(Point point) throws AssertionError{
		if(point == null){
			throw new AssertionError("Point Cannot be null");
		}
		List<Shape> listOfShapesWithEnclosingPoint = new ArrayList<Shape>(); 
		for(Shape shape : this.listOfShapes){
			if(shape.isPointEnclosed(point)){
				listOfShapesWithEnclosingPoint.add(shape);
			}
		}
		return listOfShapesWithEnclosingPoint.toArray(new Shape[listOfShapesWithEnclosingPoint.size()]);
	}
}
