package com.gl.lab5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.lab5.model.Employee;
import com.gl.lab5.service.employeeService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class employeeController {
	
	@Autowired
	employeeService empService;
	
	@GetMapping("/")
	private String HomePage() {
		return "home";
	}
	
	@GetMapping("/employees")
	private String listEmployees(Model model) {
		model.addAttribute("employees",empService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	private String createEmployees(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee",employee);
		return "create_employees";
	}
	
	@PostMapping("/employees")
	private String saveEmployees(@ModelAttribute("employee") Employee employee ) {
		empService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	private String editEmployees(@PathVariable int id , Model model) {
		model.addAttribute("employee",empService.getEmployeeByID(id));
		return "edit_employee";
	}
	
	@PostMapping("/employees/{id}")
	private String updateEmployeeById(@PathVariable int id ,@ModelAttribute("employee") Employee employee ,Model model) {
		empService.updateEmployee(id, employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/{id}")
	private String deleteEmployeeById(@PathVariable int id) {
		empService.deleteEmployeeByID(id);
		return "redirect:/employees";
	}
	
}












