package main;

/**
 * Class For represent Employee
 * @author vishnu.jangid_metacu
 *
 */
public class Employee {
	
	private int employeeId ;
	private String name;
	private String address;
	
	/**
	 * Constructor 
	 * @param employeeId int, id of Employee
	 * @param name String, name of Employee
	 * @param address String, address of Employee
	 */
	public Employee(int employeeId, String name,  String address){
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}

	/**
	 * Method to get Employee ID
	 * @return int, employee ID
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * Method to get Employee Name
	 * @return String, employee name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to get Employee Address
	 * @return String, address of Employee
	 */
	public String getAddress() {
		return address;
	}

	
	@Override
	public int hashCode() {
		return this.employeeId;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Employee && this.employeeId == ((Employee)obj).employeeId;
	}

	
}