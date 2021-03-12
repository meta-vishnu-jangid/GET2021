package main;

/**
 * Class For Employee
 * @author vishnu.jangid_metacu
 */
public class Employee {
	private final String name;
	private final int age;
	private final int salary;
	
	/**
	 * Initialize Employee Object
	 * @param name
	 * @param age
	 * @param salary
	 */
	public Employee(String name,int age, int salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	/**
	 * get name of Employee
	 * @return String, name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Get Age of Employee
	 * @return int, age
	 */
	public int getAge(){
		return this.age;
	}
	
	/**
	 * Get Salary of Employee
	 * @return int, Salary
	 */
	public int getSalary(){
		return this.salary;
	}
}
