package com.cognixia.jump.main;

import java.util.Scanner;

public class MainRunner {

	public static void main(String[] args) throws InvalidEntryException {
		System.out.println("Employee Portal v1.0");
		
		System.out.println("Please enter 1 to enter the program and 2 to exit the program.");
		
		Scanner enterProgram = new Scanner(System.in);
		
		String ans = enterProgram.nextLine();
				
		switch (ans) {
		  case "1":		    
		    RunProgram runProgram = new RunProgram();
		    
		    runProgram.runner();
		    
		    enterProgram.close();
		    
		    break;
		  case "2":
		    System.out.println("Byee!!!");
		    enterProgram.close();
		    break;
		  default:
			System.out.println("Invalid Input....exiting program!!!");
			throw new InvalidEntryException("1 or 2 only!!!");

		}
		
		
		
	}

}
