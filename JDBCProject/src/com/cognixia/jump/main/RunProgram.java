package com.cognixia.jump.main;

import java.util.Scanner;

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
				System.out.println(fileRunner.getAllEmployees());
			  		  
				System.out.println("done2");
				

				
		    break;
		  case "2":
			  System.out.println("Adding entries");

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
