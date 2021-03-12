package main;

/**
 * Class To Store Employee List in a Linked List or have method for Sorting
 * @author vishnu.jangid_metacu
 */
public class EmployeeList {
	
	public EmployeeNode headNode;
	private EmployeeNode lastNode;
	
	/**
	 * Constructor
	 */
	public EmployeeList() {
		this.headNode = null;
		this.lastNode = null;
	}
	
	/**
	 * Add Employee to lIst
	 * @param employee Employee, employee Object
	 * @return boolean, true if successfully added
	 * @throws AssertionError if employee is null
	 */
	public boolean addEmployee(Employee employee) throws AssertionError{
		if(employee == null){
			throw new AssertionError("employee cannot be null");
		}
		EmployeeNode employeeNode = new EmployeeNode(employee);
		if(this.headNode == null){
			this.headNode = employeeNode;
		}
		else{
			this.lastNode.nextEmployeeNode = employeeNode;
		}
		employeeNode.prevEmployeeNode = this.lastNode;
		this.lastNode = employeeNode;
		return true;
	}
	
	/**
	 * Method to Sort List
	 */
	public void sort(){
		EmployeeNode employeeNodeFromStart = this.headNode.nextEmployeeNode;
		while(employeeNodeFromStart!=null){
			
			EmployeeNode employeeNodeRightToCurrentNode = employeeNodeFromStart.nextEmployeeNode;
			EmployeeNode employeeNodeLeftToCurrentNode = employeeNodeFromStart.prevEmployeeNode;
			EmployeeNode employeeNodeToReplace = null;
			
			while( (employeeNodeLeftToCurrentNode.employee.getSalary() < employeeNodeFromStart.employee.getSalary()) 
					|| ( (employeeNodeLeftToCurrentNode.employee.getSalary() == employeeNodeFromStart.employee.getSalary()) 
						&& (employeeNodeLeftToCurrentNode.employee.getAge() > employeeNodeFromStart.employee.getAge())	) ){
				
				employeeNodeToReplace = employeeNodeLeftToCurrentNode;
				if(employeeNodeLeftToCurrentNode.prevEmployeeNode == null){
					break;
				}
				else{
					employeeNodeLeftToCurrentNode = employeeNodeLeftToCurrentNode.prevEmployeeNode;
				}
			}
			if(employeeNodeToReplace != null){
				employeeNodeFromStart.prevEmployeeNode.nextEmployeeNode = employeeNodeFromStart.nextEmployeeNode;
				if(employeeNodeFromStart.nextEmployeeNode != null){
					employeeNodeFromStart.nextEmployeeNode.prevEmployeeNode = employeeNodeFromStart.prevEmployeeNode;	
				}
				if(employeeNodeToReplace.prevEmployeeNode != null){
					employeeNodeToReplace.prevEmployeeNode.nextEmployeeNode = employeeNodeFromStart;	
				}
				else{
					this.headNode = employeeNodeFromStart;
				}
				employeeNodeFromStart.prevEmployeeNode = employeeNodeToReplace.prevEmployeeNode;
				employeeNodeFromStart.nextEmployeeNode = employeeNodeToReplace;
				employeeNodeToReplace.prevEmployeeNode = employeeNodeFromStart;
			}
			employeeNodeFromStart = employeeNodeRightToCurrentNode;
			
		}
	}
	
	/**
	 * Method to Show List
	 */
	public void show(){
		EmployeeNode startNode = this.headNode;
		while(startNode!=null){
			System.out.print("|Name :  " + startNode.employee.getName() + ", Salary : " +startNode.employee.getSalary() +", Age : "+startNode.employee.getAge()+ " |  -->");
			startNode = startNode.nextEmployeeNode;
		}
		System.out.print("End");
	}
}
