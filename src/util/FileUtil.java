package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Employee;

public class FileUtil {


		 private static final String FILE_NAME = "employees.txt";

		    // SAVE employee details to file
		    public static void saveToFile(Employee emp) {
		        try (FileWriter fw = new FileWriter(FILE_NAME, true);
		             BufferedWriter bw = new BufferedWriter(fw)) {

		            bw.write(emp.toString());
		            bw.newLine();

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    // READ all employee records from the file
		    public static void readFile() {
		        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

		            String line;
		            System.out.println("----- FILE RECORDS -----");

		            while ((line = br.readLine()) != null) {
		                System.out.println(line);
		            }

		        } catch (FileNotFoundException e) {
		            System.out.println("File not found! No employee data saved yet.");
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

	}
}
