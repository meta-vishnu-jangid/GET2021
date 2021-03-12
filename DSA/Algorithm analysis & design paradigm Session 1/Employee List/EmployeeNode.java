package main;

/**
 * Class For Representing Node of Employee List
 * @author vishnu.jangid_metacu
 *
 */
public class EmployeeNode {
	
	public Employee employee ;
	public EmployeeNode nextEmployeeNode;
	public EmployeeNode prevEmployeeNode;
	
	public EmployeeNode(Employee employee) {
		this.employee = employee;
		this.nextEmployeeNode = null;
		this.prevEmployeeNode = null;
	}
}
