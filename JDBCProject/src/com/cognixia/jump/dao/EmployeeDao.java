package com.cognixia.jump.dao;

import java.util.List;



public interface EmployeeDao {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(int id);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(int id);
	public boolean deleteEmployee(int id);
	
	

}
