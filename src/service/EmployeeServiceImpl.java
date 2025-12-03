package service;

import java.util.List;
import java.util.stream.Collectors;

import dao.EmployeeDAO;
import model.Employee;
import util.FileUtil;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO dao;
	
	
	
	public EmployeeServiceImpl(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void addEmployee(Employee emp) {
		dao.addEmployee(emp);
		FileUtil.saveToFile(emp);
		
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployeesByDepartment(String dept) {
		// TODO Auto-generated method stub
		return dao.getAllEmployees()
				.stream()
				.filter(e -> e.getDepartment().equalsIgnoreCase(dept))
				.collect(Collectors.toList());
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return dao.getAllEmployees();
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		dao.updateEmployee(emp);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		dao.deleteEmployee(id);
	}

}
