package com.cognixia.jump.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeDaoFileTest {
	private static int testCount;
	
	@BeforeAll
	public static void setup() {
		EmployeeDaoFile newFile4 = new EmployeeDaoFile();
		Employee employee5 = new Employee("Amesh", "Alex", 10000, "IT");
	    newFile4.addEmployee(employee5);
		testCount = 0;
		System.out.println(" Test Count : " + testCount);
	}
	
	@AfterAll
	public static void cleanup() {
		EmployeeDaoFile newFile6 = new EmployeeDaoFile();
	    assertEquals(true, newFile6.deleteEmployee(1));
		System.out.println("All tests have been run," + "total tests run is " + testCount);
	}
	
	@BeforeEach
	public void beforeTest() {
		System.out.println("Running tests ... ");
	}
	
	@AfterEach
	public void afterTest( ) {
		testCount++;
		System.out.println("Finished Running test," + " testCount = " + testCount);
	}
	
//	@Test
//	void testEntryChecker() {
//		EmployeeDaoFile newFile = new EmployeeDaoFile();
//	    String input = "add";
//	    InputStream sysInBackup = System.in; 
//	    ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
//	    System.setIn(in);
//	    System.setIn(sysInBackup);
//	    assertEquals(input, newFile.entryChecker());
//
//	}

	@Test
	void getAllEmployeesChecker() {
		EmployeeDaoFile newFile2 = new EmployeeDaoFile();
		Employee employee3 = new Employee(1, "Amesh", "Alex", 10000, "IT");
		List<Employee> employees2 = new ArrayList<Employee>();
		employees2.add(employee3);
	    assertEquals(employees2.toString(), newFile2.getAllEmployees().toString());
	}
	
	@Test
	void addEmployeeChecker() {
		EmployeeDaoFile newFile3 = new EmployeeDaoFile();
		Employee employee4 = new Employee("Amesh3", "Alex2", 10000, "IT");
	    assertEquals(true, newFile3.addEmployee(employee4));
	}
	
	@Test
	void deleteEmployeeChecker() {
		EmployeeDaoFile newFile3 = new EmployeeDaoFile();
	    assertEquals(true, newFile3.deleteEmployee(2));
	}
	
	@Test
	void getEmployeeByIdChecker() {
		EmployeeDaoFile newFile2 = new EmployeeDaoFile();
		Employee employee3 = new Employee(1, "Amesh", "Alex", 10000, "IT");
	    assertEquals(employee3.toString(), newFile2.getEmployeeById(1).toString());
	}
	
//	@Test
//	void gupdateEmployeeChecker() {
//		EmployeeDaoFile newFile7 = new EmployeeDaoFile();
//	    assertEquals(true, newFile7.updateEmployee(1));
//		
//	}
	

}
