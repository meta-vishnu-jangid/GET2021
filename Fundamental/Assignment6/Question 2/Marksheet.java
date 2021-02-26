package main;
import java.math.RoundingMode;

public class Marksheet {

	private final int grades[];
	
	
	/**
	 * Initialize Marksheet Object Using an array of grades
	 * @param grades
	 */
	public Marksheet(int[] grades ){
		this.grades = grades.clone();
	}
	
	
	
	/**
	 * Method to get Average Grades 
	 * @return Float value upto 2 decimal value , Average of Grades
	 * @throws ArithmeticException
	 */
	public float getAverageMarks() throws ArithmeticException {
		
		float average ;
		int totalMarks = 0 ;
		for ( int grade: this.grades){
			totalMarks += grade ;
		}
		average = (float) totalMarks / grades.length ;
		
		return Float.parseFloat(String.format("%.2f", average)) ;
	}
	
	
	
	/**
	 * Method to get Maximum Grade
	 * @return maximum Grade out of Grades 
	 * @throws ArithmeticException
	 */
	public int getMaxGrade() throws ArithmeticException {
		
		int maxGrade = this.grades[0];
		
		for ( int grade: this.grades){
			if( grade > maxGrade ){
				maxGrade = grade ;
			}
		}
		
		return maxGrade ;
	}
	
	
	
	/**
	 * Method to get Minimum Grade
	 * @return minimum Grade out of Grades 
	 * @throws ArithmeticException
	 */
	public int getMinGrade()throws ArithmeticException {
        
		int minGrade = this.grades[0];
		
		for ( int grade: this.grades){
			if( grade < minGrade ){
				minGrade = grade ;
			}
		}
		
		return minGrade ;
	}
	
	
	/**
	 * Method to get Percentage of Students Passed
	 * @return A Float value upto 2 decimal value , percentage of Students passed
	 * @throws ArithmeticException
	 */
	public float getPercentageOfStudentsPassed() throws ArithmeticException {
		
		int noOfStudentsPassed = 0;
		float percentage ;
		
		for ( int grade: this.grades){
			if( grade >= 40 ){
				noOfStudentsPassed++;
			}
		}
		
		percentage = (float)(noOfStudentsPassed) * 100 / this.grades.length ;
		
		return  Float.parseFloat(String.format("%.2f",percentage ));
	}
	
}
