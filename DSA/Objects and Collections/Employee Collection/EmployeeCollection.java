package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class For Employeee Collection
 * @author vishnu.jangid_metacu
 *
 */
public class EmployeeCollection {
	
	private ArrayList<Employee> employeeCollection;
	
	/**
	 * Constructor
	 */
	public EmployeeCollection() {
		this.employeeCollection = new ArrayList<Employee>();
	}
	
	/**
	 * Get Collection sorted by Natural Order
	 * @return Employee[], array of sorted employees by id
	 */
	public Employee[] sortCollectionByNaturalOrder(){
		class EmployeeIdComparator implements Comparator<Employee>{
			@Override
			public int compare(Employee employee1, Employee employee2){
				return employee1.getEmployeeId() - employee2.getEmployeeId();
			}
		}
		Collections.sort((List<Employee>) this.employeeCollection , new EmployeeIdComparator() );
		return ((ArrayList<Employee>) this.employeeCollection.clone()).toArray(new Employee[this.employeeCollection.size()]);
	}
	
	/**
	 * Method to get Sorted list of Employees by name
	 * @return Employee[], sorted Array of Employee
	 */
	public Employee[] sortCollectionByEmployeeName(){
		class EmployeeNameComparator implements Comparator<Employee>{
			@Override
			public int compare(Employee employee1, Employee employee2){
				return employee1.getName().compareTo(employee2.getName());
			}
		}
		Collections.sort((List<Employee>) this.employeeCollection , new EmployeeNameComparator() );
		return ((ArrayList<Employee>) this.employeeCollection.clone()).toArray(new Employee[this.employeeCollection.size()]);
	}
	
	/**
	 * Method to add Employee to Collection
	 * @param employee Employee, employee to be added
	 * @return boolean, true if employee added or false if employee with same ID is already present
	 */
	public boolean addEmployee(Employee employee){
		for(Employee employeeInCollection : this.employeeCollection)
			if(employeeInCollection.equals(employee)){
				return false;
			}
		this.employeeCollection.add(employee);
		return true;
	}
}