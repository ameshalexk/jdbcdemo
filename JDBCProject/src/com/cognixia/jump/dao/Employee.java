package com.cognixia.jump.dao;


public class Employee {
	
	private int id;
	private String first_Name;
	private String last_Name;
	private int salary;
	private String department;
	
	public Employee() {
		
	}

	public Employee(int id, String first_Name, String last_name, int salary, String department) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_name;
		this.salary = salary;
		this.department = department;
	}

	public Employee(String first_Name, String last_name, int salary, String department) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_name;
		this.salary = salary;
		this.department = department;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return  id + " " + first_Name  + " " + last_Name + " " +  salary + " " +  department ;
	}
	
	
	
	

}
