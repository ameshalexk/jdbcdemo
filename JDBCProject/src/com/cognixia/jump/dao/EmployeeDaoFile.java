package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManagerWithProps;



public class EmployeeDaoFile implements EmployeeDao  {
	private Connection connection = ConnectionManagerWithProps.getConnection();

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
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
