package com.gl.lab5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.lab5.model.Employee;
import com.gl.lab5.repository.repositorySpringEMS;

@Service
public class employeeService implements employeeServiceInterface{
	
	@Autowired
	repositorySpringEMS employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeByID(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(int id,Employee employee) {
		Employee emp = getEmployeeByID(id);
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		return saveEmployee(employee);
	}

	@Override
	public void deleteEmployeeByID(int id) {
		employeeRepository.deleteById(id);
	}
	
	

}
