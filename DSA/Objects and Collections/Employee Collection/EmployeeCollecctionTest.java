package main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class For Test Employee Collection 
 * @author vishnu.jangid_metacu
 *
 */
public class EmployeeCollecctionTest {

	/**
	 * Method to test addEmployee Method
	 */
	@Test
	public void addTest() {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		
		assertEquals(true, employeeCollection.addEmployee(new Employee(3, "zbc", "xa")));
		assertEquals(true, employeeCollection.addEmployee(new Employee(1, "abc", "xa")));
		assertEquals(true, employeeCollection.addEmployee(new Employee(2, "bbc", "xa")));
		assertEquals(false, employeeCollection.addEmployee(new Employee(1, "abc", "xa")));
		
	}
	
	
	/**
	 * Method to test Sort Method of Employee Collection
	 */
	@Test
	public void sortTest(){
		EmployeeCollection employeeCollection = new EmployeeCollection();
		
		assertEquals(true, employeeCollection.addEmployee(new Employee(3, "zbc", "xa")));
		assertEquals(true, employeeCollection.addEmployee(new Employee(1, "abc", "xa")));
		assertEquals(true, employeeCollection.addEmployee(new Employee(2, "bbc", "xa")));
		assertEquals(false, employeeCollection.addEmployee(new Employee(1, "abc", "xa")));
		
		assertArrayEquals(new Employee[]{new Employee(1, "abc", "xa"),new Employee(2, "bbc", "xa"),new Employee(3, "zbc", "xa")},employeeCollection.sortCollectionByNaturalOrder() );
	}
	
	/**
	 * Method to test Sort Employee Collection by Name
	 */
	@Test
	public void sortByNameTest(){
		EmployeeCollection employeeCollection = new EmployeeCollection();
		
		assertEquals(true, employeeCollection.addEmployee(new Employee(3, "abc", "xa")));
		assertEquals(true, employeeCollection.addEmployee(new Employee(1, "bbc", "xa")));
		assertEquals(true, employeeCollection.addEmployee(new Employee(2, "zbc", "xa")));
		assertEquals(false, employeeCollection.addEmployee(new Employee(1, "bbc", "xa")));
		
		assertArrayEquals(new Employee[]{new Employee(3, "abc", "xa"),new Employee(1, "bbc", "xa"),new Employee(2, "zbc", "xa")},employeeCollection.sortCollectionByEmployeeName() );
	}

}
