package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {

	void addEmployee(Employee emp);
	void updateEmployee(Employee emp);
	void deleteEmployee(int id);
	Employee getEmployeeById(int id);
	List<Employee> getAllEmployees();
}
