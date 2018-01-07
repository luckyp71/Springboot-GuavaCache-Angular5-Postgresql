package com.example.main.service;

import com.example.main.model.Employee;

import java.util.Collection;

public interface EmployeeService {
	
	//Return list of employees
	Collection<Employee> getEmployees() throws InterruptedException;
	
	//Return a single object of employee
	Employee getEmployee(Long id) throws InterruptedException;
	
	//Create new employee
	String createEmployee(Employee employee) throws InterruptedException;
	
	//Update employee
	String updateEmployee(Employee employee) throws InterruptedException;
	
	//Delete employee
	String deleteEmployee(Long id) throws InterruptedException;

}
