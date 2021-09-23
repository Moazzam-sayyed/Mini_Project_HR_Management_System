package com.dao;

import com.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
	
	boolean addEmployee(Employee employee);
	boolean updateEmployee(Employee updateEmployee);
	boolean deleteEmployee(int id);
	public List<Employee> getAllEmployee();
	public List<Employee> searchEmployee(int searchId);
	public Map<String, Integer> getDepartmentwiseCount();

}
