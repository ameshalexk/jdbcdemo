package com.cognixia.jump.main;

import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.dao.Employee;
import com.cognixia.jump.dao.EmployeeDaoFile;



public class RunProgram {
	
	public void runner () {
		System.out.println("Welcome, please enter the below codes to run data operations - \n");
	    System.out.println("1 - View entries");
	    System.out.println("2 - Add entries");
	    System.out.println("3 - Remove entries");
	    System.out.println("4 - Delete entries");
	    
		Scanner enterProgram2 = new Scanner(System.in);
		
		String ans2 = null;
		try {
			ans2 = enterProgram2.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    enterProgram2.close();

	    switch (ans2) {
		  case "1":
			  System.out.println("Getting entries");
			  
				EmployeeDaoFile fileRunner = new EmployeeDaoFile();
				List<Employee> employee = fileRunner.getAllEmployees();
				
				System.out.println("----------------------------------------------------------------------------------------------------------");
		        System.out.printf("%20s %20s %20s %20s %20s", "ID", "FIRST NAME", "LAST NAME", "SALARY (USD)", "DEPARTMENT");
		        System.out.println();
				System.out.println("----------------------------------------------------------------------------------------------------------");

		        for(int i = 0; i < employee.size(); i++){
		        	Object query = employee.get(i);
		        	
		        	String s = query.toString();
		        	
		        	String[] arrOfStr = s.split(" ");
		        	
		        	for (String a : arrOfStr)
		        		System.out.format("%20s",a);
		        	System.out.println();
		        			
		        }
		        
				System.out.println("----------------------------------------------------------------------------------------------------------");
		 				
								
		    break;
		  case "2":
			  System.out.println("Adding entries");
			  			  
			  	System.out.println("Please enter the below data to create the entry - \n");
			    System.out.println("1 - Enter below the First name of the employee - ");
	    
				Scanner one = new Scanner(System.in);
				
				String first_name = null;
				String last_name = null;
				String salary = null;
				String department = null;
				
				
				
//				try {
//					id = enterProgram2.next();
//					Employee newEmployee = new Employee(id, first_name, last_name, salary, department);
//					
//					
//					
//					
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				
			    enterProgram2.close();
			  
			  
			  
			  
				EmployeeDaoFile fileRunner2 = new EmployeeDaoFile();
//				fileRunner2.addEmployee(employeeObject);
				

		    break;
		  case "3":
			  System.out.println("Removing entries");

			break;
		  case "4":
			  System.out.println("Deleting entries");

			break;
		  default:
		    System.out.println("Invalid Input....exiting program!!!");
		    enterProgram2.close();
		}
	    
	    
	    
	    
	}

}
