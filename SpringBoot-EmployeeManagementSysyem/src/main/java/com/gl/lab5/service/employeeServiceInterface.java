package com.gl.lab5.service;

import java.util.List;

import com.gl.lab5.model.Employee;

public interface employeeServiceInterface {
	
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeByID(int id);
	
	Employee updateEmployee(int id,Employee employee);
	
	void deleteEmployeeByID(int id);
}
