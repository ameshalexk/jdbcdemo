package com.cognixia.jump.dao;

import java.util.List;


public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(Employee employee);
	
	

}
