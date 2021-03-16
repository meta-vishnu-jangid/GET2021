package main;

/**
 * Class For Node of EmployeeList
 * @author vishnu.jangid_metacu
 *
 */
public class EmployeeNode {
	int age;
	Double salary;
	String id;
	EmployeeNode next;
	
	/**
	 * Constructor
	 * @param id String
	 * @param salary Double
	 * @param age int
	 */
	public EmployeeNode(String id , Double salary , int age) {
		this.id = id;
		this.age = age;
		this.salary = salary;
		next = null;
	}
}