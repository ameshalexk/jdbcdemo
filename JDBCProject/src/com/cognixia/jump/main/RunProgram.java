package com.cognixia.jump.main;

import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.dao.Employee;
import com.cognixia.jump.dao.EmployeeDaoFile;

public class RunProgram {

	public void runner() throws InvalidEntryException {
		System.out.println("Welcome, please enter the below codes to run data operations - \n");
		System.out.println("1 - View entries");
		System.out.println("2 - Add entries");
		System.out.println("3 - Update entries");
		System.out.println("4 - Delete entries");

		Scanner enterProgram2 = new Scanner(System.in);

		String ans2 = null;
		try {
			ans2 = enterProgram2.next();
		} catch (Exception e) {
			e.printStackTrace();
		}

		switch (ans2) {
		case "1":
			System.out.println("Getting entries");

			EmployeeDaoFile fileRunner = new EmployeeDaoFile();
			List<Employee> employee = fileRunner.getAllEmployees();

			System.out.println(
					"----------------------------------------------------------------------------------------------------------");
			System.out.printf("%20s %20s %20s %20s %20s", "ID", "FIRST NAME", "LAST NAME", "SALARY (USD)",
					"DEPARTMENT");
			System.out.println();
			System.out.println(
					"----------------------------------------------------------------------------------------------------------");

			for (int i = 0; i < employee.size(); i++) {
				Object query = employee.get(i);

				String s = query.toString();

				String[] arrOfStr = s.split(" ");

				for (String a : arrOfStr)
					System.out.format("%20s", a);
				System.out.println();
			}
			System.out.println(
					"----------------------------------------------------------------------------------------------------------");

			break;
		case "2":
			System.out.println("Adding entries");
			System.out.println("Please enter the below data to create the entry - \n");

			try {

				Scanner one = new Scanner(System.in);
				System.out.println("1 - Enter below the First name of the employee - ");
				String first_name = one.next();
				System.out.println("2- Enter below the Last name of the employee - ");
				String last_name = one.next();
				System.out.println("3 - Enter below the Salary of the employee - ");
				String sal = one.next();
				int salary = Integer.parseInt(sal);
				System.out.println("4 - Enter below the department of the employee - ");
				String department = one.next();
				Employee newEmployee = new Employee(first_name, last_name, salary, department);
				EmployeeDaoFile fileRunner2 = new EmployeeDaoFile();
				fileRunner2.addEmployee(newEmployee);
				one.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "3":
			System.out.println("Updating entries");
			
			System.out.println("Please enter the id to update the entry - \n");

			try {

				Scanner two = new Scanner(System.in);
				String idData = two.next();
				int idArg = Integer.parseInt(idData);
				EmployeeDaoFile fileRunner3 = new EmployeeDaoFile();
				fileRunner3.updateEmployee(idArg);
				two.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			

			break;
		case "4":
			System.out.println("Deleting entries");
			
			System.out.println("Please enter the id to delete the entry - \n");

			try {

				Scanner two = new Scanner(System.in);
				String idDel = two.next();
				int idArg = Integer.parseInt(idDel);
				EmployeeDaoFile fileRunner4 = new EmployeeDaoFile();
				fileRunner4.deleteEmployee(idArg);
				two.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			

			break;
		default:
			System.out.println("Invalid Input....exiting program!!!");
			enterProgram2.close();
			throw new InvalidEntryException("1 or 2 or 3 or 4 only!!!");

		}

	}

}
