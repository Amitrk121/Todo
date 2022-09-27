package com.springboot.cntl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@PostMapping("/employees")
	public void saveDetails(@RequestBody Employee theEmployees) {
		service.saveDetails(theEmployees);
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList=service.getEmployees();
		return employeeList;
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee emp=service.getEmployeeById(id);
		return emp;
	}
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		service.deleteEmp(id);
	}
	@PutMapping("/employees/{id}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
		service.updateEmp(employee,id);
	}
}
