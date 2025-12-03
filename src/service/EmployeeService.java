package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {

	void addEmployee(Employee emp);
	
	Employee getEmployee(int id);
	
	List<Employee> getEmployeesByDepartment(String dept);
	
	List<Employee> getAllEmployees();
	
	void updateEmployee(Employee emp);
	
	void deleteEmployee(int id);
}
