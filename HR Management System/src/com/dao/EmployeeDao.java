package com.dao;

import com.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {
	
	//method to add data into database
	boolean addEmployee(Employee employee);

	//name validation method
	boolean NameValidation(String name);
	
	//method to update detail
	boolean updateEmployee(Employee updateEmployee);
	
	//method to delete data
	boolean deleteEmployee(int id);
	
	//method to feat all employee detail
	public List<Employee> getAllEmployee();
	
	//method to search employee detail
	public List<Employee> searchEmployee(int searchId);
	
	//Report APIs
	public Map<String, Integer> getDepartmentwiseCount();
	public List<Employee> getEmpByDepartmentName(String department);

}
