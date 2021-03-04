package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test Class For Screen Class
 * @author vishnu.jangid_metacu
 *
 */
public class ScreenTest {

	/**
	 * Method for Testing Screen Class Methods 
	 */
	@Test
	public void testScreen() {
		
		Shape circleShape = ShapeFactory.createShape("Circle", new Point(3, 3),new int[]{2} );
		Shape squareShape = ShapeFactory.createShape("Square", new Point(5, 5),new int[]{2} );
		Shape rectangleShape = ShapeFactory.createShape("Rectangle", new Point(8, 8),new int[]{1,2} );
		
		Screen screen = new Screen();
		
		assertEquals(true,screen.addShape(circleShape));
		assertEquals(true,screen.addShape(squareShape));
		assertEquals(true,screen.addShape(rectangleShape));
		
		assertArrayEquals(new Shape[] {rectangleShape,squareShape,circleShape},screen.getShapesSortedByArea());
		assertArrayEquals(new Shape[] {circleShape,squareShape,rectangleShape},screen.getShapesSortedByOriginDistance());
		assertArrayEquals(new Shape[] {rectangleShape,squareShape,circleShape},screen.getShapesSortedByPerimeter());
		assertArrayEquals(new Shape[] {circleShape,squareShape,rectangleShape},screen.getShapesSortedByTimeStamp());
		assertArrayEquals(new Shape[] {squareShape},screen.getShapesEnclosingAPoint(new Point(5,5)));
		assertArrayEquals(new Shape[] {},screen.getShapesEnclosingAPoint(new Point(0,0)));
	
		
		assertEquals(true,screen.deleteShape(circleShape));
		assertEquals(false,screen.deleteShape(circleShape));
		
		assertEquals(false, screen.deleteShapesOfSpecificType("Circle"));
		assertEquals(true, screen.deleteShapesOfSpecificType("Square"));
		assertEquals(false, screen.deleteShapesOfSpecificType("Line"));
		
	}
	
	
	/**
	 * Test Class Methods For  Exception in addShape() Method
	 */
	@Test(expected = AssertionError.class)
	public void addShapeException(){
		Screen screen = new Screen();
		
		screen.addShape(null);
	}
	
	/**
	 * Test Class Methods For  Exception in deleteShape() Method
	 */
	@Test(expected = AssertionError.class)
	public void deleteShapeException(){
		Screen screen = new Screen();
		
		screen.deleteShape(null);
	}
	
	/**
	 * Test Class Methods For  Exception in getShapesEnclosingAPoint() Method
	 */
	@Test(expected = AssertionError.class)
	public void getShapesEnclosingAPointException(){
		Screen screen = new Screen();
		
		screen.getShapesEnclosingAPoint(null);
	}

	/**
	 * Test Class Methods For  Exception in deleteShapesOfSpecificType() Method
	 */
	@Test(expected = AssertionError.class)
	public void deleteShapesOfSpecificTypeException(){
		Screen screen = new Screen();
		
		screen.deleteShapesOfSpecificType(null);
	}
	
}
