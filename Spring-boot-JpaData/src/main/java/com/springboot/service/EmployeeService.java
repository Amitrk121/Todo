package com.springboot.service;

import java.util.List;

import com.springboot.entity.Employee;

public interface EmployeeService {
	public void saveDetails(Employee theEmployees);

	public List<Employee> getEmployees();

	public Employee getEmployeeById(int id);

	public void deleteEmp(int id);

	public void updateEmp(Employee employee,int id);
}
