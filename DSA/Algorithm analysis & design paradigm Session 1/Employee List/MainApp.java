package main;

public class MainApp {
	public static void main(String args[]){
		
		
		EmployeeList employeeList = new EmployeeList(); // Sorted Reverse
		EmployeeList employeeList2 = new EmployeeList(); // Already SOrted
		EmployeeList employeeList3 = new EmployeeList(); // Equal Salary with different Ages
		
		employeeList.addEmployee(new Employee("Emp1", 24, 10000));
		employeeList.addEmployee(new Employee("Emp2", 25, 20000));
		employeeList.addEmployee(new Employee("Emp3", 23, 30000));
		employeeList.addEmployee(new Employee("Emp4", 25, 40000));
		
		employeeList2.addEmployee(new Employee("Emp1", 24, 40000));
		employeeList2.addEmployee(new Employee("Emp2", 25, 30000));
		employeeList2.addEmployee(new Employee("Emp3", 23, 20000));
		employeeList2.addEmployee(new Employee("Emp4", 25, 10000));
		
		employeeList3.addEmployee(new Employee("Emp1", 25, 40000));
		employeeList3.addEmployee(new Employee("Emp2", 25, 20000));
		employeeList3.addEmployee(new Employee("Emp3", 23, 20000));
		employeeList3.addEmployee(new Employee("Emp4", 24, 40000));
		
		System.out.println("\nLIST 1 : \n");
		System.out.print("Before Sort: \n");
		employeeList.show();
		
		employeeList.sort();
		
		System.out.print("\nAfter Sort: \n");
		employeeList.show();
		
		System.out.println("\nLIST 2 : \n");
		System.out.print("Before Sort: \n");
		employeeList2.show();
		
		employeeList2.sort();
		
		System.out.print("\nAfter Sort: \n");
		employeeList2.show();
		
		System.out.println("\nLIST 3 : \n");
		System.out.print("Before Sort: \n");
		employeeList3.show();
		
		employeeList3.sort();
		
		System.out.print("\nAfter Sort: \n");
		employeeList3.show();
	}
}
