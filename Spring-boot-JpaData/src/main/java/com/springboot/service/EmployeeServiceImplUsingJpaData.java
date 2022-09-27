package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.EmployeeRepository;
import com.springboot.entity.Employee;
import com.springboot.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImplUsingJpaData implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public void saveDetails(Employee theEmployees) {
		// TODO Auto-generated method stub
		empRepository.save(theEmployees);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return empRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> result = empRepository.findById(id);
		Employee emp = null;
		if (result.isPresent()) {
			emp = result.get();
		} else {
			throw new EmployeeNotFoundException("Employee not found by id " + id);
		}
		
		return emp;
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		empRepository.deleteById(id);
	}

	@Override
	public void updateEmp(Employee employee,int id) {
		// TODO Auto-generated method stub
		Employee emp=new Employee();
		emp.setId(id);
		emp.setCity(employee.getCity());
		emp.setName(employee.getName());
		emp.setSalary(employee.getSalary());
		empRepository.save(emp);
	}

}
