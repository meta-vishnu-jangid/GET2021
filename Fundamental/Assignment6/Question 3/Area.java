package main;

public class Area {

	
	/**
	 * Method to get Area of Triangle
	 * @param height Height of Triangle , Requires height is greater then zero
	 * @param width Width of Triangle , Requires Width is greater then zero
	 * @return Area of Triangle
	 * @throws ArithmeticException
	 */
	public static double areaOfTriangle( double height , double width ) throws ArithmeticException{
	
		double area ;
		
		area = 0.5 * height * width ;
		
		return area ;
	}
	
	
	
	/**
	 * Method to get Area of Rectangle
	 * @param height Height of  Rectangle , Requires height is greater then zero
	 * @param width Width of Rectangle , Requires Width is greater then zero
	 * @return Area of Rectangle
	 * @throws ArithmeticException
	 */
    public static double areaOfRectangle( double height , double width  ) throws ArithmeticException{
    	
    	double area ;
    	
    	area = height * width ;
    	
		return area ;
	}
    
    
    
    /**
     * Method to get Area of Square
     * @param side Side of Square , Requires side is greater then zero
     * @return Area of Square 
     * @throws ArithmeticException
     */
    public static double areaOfSquare( double side ) throws ArithmeticException{
    	
    	double area ;
    	
    	area = side * side ;
    	
		return area ;
	}
    
    
    
    /**
     * Method to get Area of Circle
     * @param radius Radius of Circle , Requires Radius is Greater then zero
     * @return Area of Circle
     * @throws ArithmeticException
     */
    public static double areaOfCircle( double radius ) throws ArithmeticException{
    	
    	double area ;
    	
    	area = 22/7 * radius * radius ;
    	
		return area ;
	}

}
