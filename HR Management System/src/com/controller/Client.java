package com.controller;
import java.util.Scanner;

import com.dao.DepartmentDao;
import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImplementation;
import com.model.Employee;

public class Client {
	
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDaoImplementation();
		Scanner sc= new Scanner(System.in);
		
		//Employee Menu
		System.out.println("1 --> Add New Eployee");			
		System.out.println("2 --> Update Eployee");	
		System.out.println("3-->Delete Employee Detail");
		System.out.println("Please Enter Your Choice");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1: System.out.println("Enter Employye ID:");		//add new employee
			int empId = sc.nextInt();
			System.out.println("Enter Employye Name:");
			String empName = sc.next();
			System.out.println("Enter Address:");
			String empAdd = sc.next();
			System.out.println("Enter Email ID:");
			String empMailId = sc.next();
			System.out.println("Enter Mobile Number:");
			int empMob = sc.nextInt();
			System.out.println("Enter Department ID");
			int empDeptId = sc.nextInt();
			System.out.println("Enter Role ID");
			int empRoleId = sc.nextInt();
			
			Employee employee = new Employee(empId, empName, empAdd, empMailId, empMob, empDeptId, empRoleId);
			boolean isinsert = empDao.addEmployee(employee);
			if(isinsert) 
				System.out.println("record added Succesfully");
			else
				System.out.println("Unsuccesfull insertoin!!");
			break;
			
			
		case 2: System.out.println("Enter Employye ID To Update:");			//Update Existing Employee
			int updateEmpId = sc.nextInt();
			System.out.println("Enter New Name:");
			String newEmpName = sc.next();
			System.out.println("Enter New Address:");
			String newEmpAdd = sc.next();
			System.out.println("Enter  New Email ID:");
			String newEmpMailId = sc.next();
			System.out.println("Enter New Mobile Number:");
			int newEmpMob = sc.nextInt();
			System.out.println("Enter New Department ID");
			int newEmpDeptId = sc.nextInt();
			System.out.println("Enter New Role ID");
			int newEmpRoleId = sc.nextInt();
			
			Employee updateEmployee = new Employee(updateEmpId,newEmpName, newEmpAdd, newEmpMailId, newEmpMob, newEmpDeptId, newEmpRoleId);
			boolean isupdate = empDao.updateEmployee(updateEmployee);
			if(isupdate) 
				System.out.println("record Updated Succesfully");
			else
				System.out.println("Unsuccesfull updation!!");
			break;
			
		case 3:System.out.println("Enter Employee Id to Delete Employee Detail:");		//delete record from emloyee table
				int deleteEmpId =sc.nextInt();
//				Employee deleteEmployee = new Employee();
//				deleteEmployee.setEmployeeId(deleteEmpId);
//				int getId = deleteEmployee.getEmployeeId();
				boolean isdelete = empDao.deleteEmployee(deleteEmpId);
				if(isdelete)
					System.out.println("Record deleted Successfully..");
				else
					System.out.println("unsuccesful deletion.");
		}
	}

}
