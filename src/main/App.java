package main;

import java.util.Scanner;

import dao.EmployeeDAOImpl;
import model.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import thread.BackgroundLogger;

public class App {

	public static void main(String[] args) {
		new BackgroundLogger().start();
		
		Scanner sc = new Scanner(System.in);
		EmployeeService service = new EmployeeServiceImpl(new EmployeeDAOImpl());
		
		while(true) {
			System.out.println("\n===== Employee Management =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee");
            System.out.println("3. Get Employees by Department");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            
            switch(choice) {
            case 1:
            	System.out.println("Enter ID, Name, Salary, Department:");
            	Employee emp = new Employee(
            			sc.nextInt(),
            			sc.next(),
            			sc.nextDouble(),
            			sc.next()
            			);
            	service.addEmployee(emp);
            	break;
            	
            case 2:
            	System.out.println("Enter ID:");
            	System.out.println(service.getEmployee(sc.nextInt()));
            	break;
            	
            case 3:
            	System.out.println("Department: ");
            	service.getEmployeesByDepartment(sc.next())
            	.forEach(System.out::println);
            	break;
            	
            case 4:
            	return;
            }
		}

	}

}
