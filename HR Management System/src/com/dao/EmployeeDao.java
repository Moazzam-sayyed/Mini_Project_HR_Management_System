package com.dao;

import com.model.Employee;
import java.util.List;

public interface EmployeeDao {
	
	boolean addEmployee(Employee employee);
	boolean updateEmployee(Employee updateEmployee);
	boolean deleteEmployee(int id);
	public List<Employee> getAllEmployee();

}
