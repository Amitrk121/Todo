package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.entity.Employee;
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
