package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.connection.ConnectionManagerWithProps;
import com.cognixia.jump.main.RunProgram;

public class EmployeeDaoFile implements EmployeeDao {
	private Connection connection = ConnectionManagerWithProps.getConnection();
	Scanner one = new Scanner(System.in);

	private String entryChecker() {
		String line = null;
		String output = "";
		if (!(line = one.nextLine()).isEmpty()) {
			String values = line;
			output = values;
		}
		return output;

	};

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<Employee>();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM employees");

			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				int salary = rs.getInt("salary");
				String department = rs.getString("department");

				Employee employee = new Employee(id, first_name, last_name, salary, department);
				employees.add(employee);
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public boolean addEmployee(Employee employee) {

		int count = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO employees " + "(first_name, last_name, salary, department) " + "VALUES (?,?,?,?)");

			statement.setString(1, employee.getFirst_Name());
			statement.setString(2, employee.getLast_Name());
			statement.setInt(3, employee.getSalary());
			statement.setString(4, employee.getDepartment());

			count = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (count == 1){
			System.out.println("Added Employee : " + employee.getFirst_Name() + employee.getLast_Name());
			return true;			
		}
		return false;
	}

	@Override
	public boolean updateEmployee(int id) {

		Employee employee2 = getEmployeeById(id);

		System.out.println("The selected Employee is : ");

		System.out.println(employee2.toString());

		System.out.println("What do you want to update about " + employee2.getFirst_Name() + " ?");

		System.out.println("Enter updated First Name, please leave blank if no change");

		String firstname = entryChecker();
		if (!firstname.isBlank()) {
			employee2.setFirst_Name(firstname);

		}

		System.out.println("Enter updated Last Name, please leave blank if no change");

		String lastname = entryChecker();
		if (!lastname.isBlank()) {
			employee2.setLast_Name(lastname);

		}
		System.out.println("Enter updated Salary, please leave blank if no change");

		String salary = entryChecker();
		if (!salary.isBlank()) {
			int intSalary = Integer.parseInt(salary);
			employee2.setSalary(intSalary);

		}

		System.out.println("Enter updated Department, please leave blank if no change");

		String department = entryChecker();
		if (!department.isBlank()) {
			employee2.setDepartment(department);

		}

		System.out.println(employee2.toString());
		one.close();
		
		int count = 0;
		try {
			PreparedStatement statement = connection.prepareStatement("UPDATE employees "
					+ "SET first_name = ?, last_name = ?, salary = ?, department = ? " + "WHERE id = ?");

			statement.setString(1, employee2.getFirst_Name());
			statement.setString(2, employee2.getLast_Name());
			statement.setInt(3, employee2.getSalary());
			statement.setString(4, employee2.getDepartment());
			statement.setInt(5, employee2.getId());

			count = statement.executeUpdate();

			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (count == 1) {
			System.out.println("Employee entry updated for : " + employee2.getFirst_Name() + employee2.getLast_Name());
			return true;
		}
		System.out.println("Nothing to update!");
			
		return false;

	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee employee = new Employee();

		int count = 0;
		try {
			PreparedStatement statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
			statement.setInt(1, id);
			count = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (count == 1) {
			System.out.println("Deleted entry!");
			return true;
		}
		System.out.println("entry not found ");

		return false;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = new Employee();

		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM employees WHERE id = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				employee.setId(rs.getInt(1));
				employee.setFirst_Name(rs.getString("first_name"));
				employee.setLast_Name(rs.getString("last_name"));
				employee.setSalary(rs.getInt("salary"));
				employee.setDepartment(rs.getString("department"));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Employee entry found!");
		return employee;
	}

}
