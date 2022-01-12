package com.cognixia.jump.main;

import java.util.Scanner;

public class RunProgram {
	
	public void runner () {
		System.out.println("Welcome, please enter the below codes to run data operations - \n");
	    System.out.println("1 - View entries");
	    System.out.println("2 - Add entries");
	    System.out.println("3 - Remove entries");
	    System.out.println("4 - Delete entries");
	    
		Scanner enterProgram2 = new Scanner(System.in);
		
		String ans = enterProgram2.nextLine();
		
	    
	    switch (ans) {
		  case "1":
			  System.out.println("Getting entries");
			  
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
