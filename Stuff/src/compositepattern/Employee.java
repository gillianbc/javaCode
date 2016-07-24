package compositepattern;

import java.util.ArrayList;
import java.util.List;

/*
 * A self-joining class
 */
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;
    
	// constructor
	public Employee(String name, String dept, int sal) {
		this.name = name;
		this.dept = dept;
		this.salary = sal;
		subordinates = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void printStaff() {
		boolean first = true;
		for (Employee staff : getSubordinates()) {
			if (first){
				System.out.println("Staff of " + this.name);
				first = false;
			}
			System.out.println(staff);
			staff.printStaff();
		}
	}

	public String toString() {
		return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]");
	}
}