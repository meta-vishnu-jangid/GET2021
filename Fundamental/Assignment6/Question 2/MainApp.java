package main;
import main.Marksheet;

public class MainApp {

	public static void main(String[] args) {
		
		int[] grades = { 40, 50, 60, 30, 20, 10, 100, 0 , 50 } ;
		
		Marksheet marksheet = new Marksheet(grades);
	
		System.out.println("Average Grades : " + marksheet.getAverageMarks());
		System.out.println("\nMaximum Grade : " + marksheet.getMaxGrade());
		System.out.println("\nMinimum Grades : " + marksheet.getMinGrade());
		System.out.println("\nPercentage of Students Passed : " + marksheet.getPercentageOfStudentsPassed());
	}

}
