package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void addEmployee(Employee emp) {
		String sql = "INSERT INTO employees VALUES (?,?,?,?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getDepartment());
			ps.executeUpdate();
		} catch (Exception e) { e.printStackTrace(); }
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		String sql = "UPDATE employees SET name=?, salary=?, department=? WHERE id=?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			
			ps.setString(1, emp.getName());
			ps.setDouble(2, emp.getSalary());
		    ps.setDepartment(3, emp.getDepartment());
			ps.executeUpdate();
			
		} catch (Exception e) { e.printStackTrace();}
		
	}

	@Override
	public void deleteEmployee(int id) {
		String sql = "DELETE FROM EMPLOYEES WHERE id =?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1,id);
			ps.executeUpdate();
		} catch( Exception e) { e.printStackTrace(); }
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		String sql = "SELECT * FROM EMPLOYEES WHERE id = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Employee(
						rs.getInt(1),
						rs.getString(2),
						rs.getDouble(3),
						rs.getString(4));
			}
		} catch(Exception e) {e.printStackTrace();}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		
		 String sql = "SELECT * FROM employees";

	        try (Connection con = DBConnection.getConnection();
	             Statement st = con.createStatement();
	             ResultSet rs = st.executeQuery(sql)) {

	            while (rs.next()) {
	                list.add(new Employee(
	                        rs.getInt(1),
	                        rs.getString(2),
	                        rs.getDouble(3),
	                        rs.getString(4)
	                ));
	            }
		
	} catch (Exception e) {e.printStackTrace();}
	        return list;
}
}
