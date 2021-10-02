package com.controller;
import com.dao.EmployeeDao;
import com.model.Employee;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
//import com.sun.org.apache.xpath.internal.operations.Bool;
import com.dao.EmployeeDaoImplementation;
import com.dao.UserAuthentication;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Client {
	
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDaoImplementation();
		Scanner sc= new Scanner(System.in);
		boolean runSwitch = true;
		
		UserAuthentication userAu = new UserAuthentication();
		boolean isAuthenticated = userAu.authentication();
		
		//Check login Credential to validate user---------------------------------------------------------------  
		if(isAuthenticated)
		{
			System.out.println("Welcom");
			//Employee Menu//
			System.out.println();
			
			System.out.println("				    **********WELCOME TO HR MANAGEMENT SYSTEM********");
			do {
			System.out.println("");
			System.out.println("                     			 +--------------------------------------+");
			System.out.println();
			System.out.println("					 |  1	|Add New Eployee        	|");	
			System.out.println("					 |	|				|");
			System.out.println("					 |  2	|Update Eployee			|");	
			System.out.println("					 |	|				|");
			System.out.println("					 |  3	|Delete Employee Detail	 	|");
			System.out.println(" 					 |	|				|");
			System.out.println("					 |  4	| Show All Employee		|");
			System.out.println("   					 |	|				|");
			System.out.println("					 |  5	| Search Employee               |");
			System.out.println(" 					 |	|				|");
			System.out.println("					 |  6	| Departmentwise Report         |");
			System.out.println("					 |  	| 				|");
			System.out.println("					 |  7	| Employee By Department Name   |");
			System.out.println("					 |  	|			   	|");
			System.out.println("					 |  8	| Logout   			|");
			System.out.println("					 +--------------------------------------+");
			System.out.println("					 | Please Enter Your Choice		|");

			int choice = sc.nextInt();
				switch(choice)
				{
				//To add new employee
				case 1: System.out.println("Enter Employye ID:");		
						int empId = sc.nextInt();
						
						//Name Validation---------------------------------------
						String empName = null;
						boolean nameflag=true;
						while(nameflag)
						{
							System.out.println("Enter Employye Name:");
							empName = sc.next();
						
							boolean isValid = empDao.NameValidation(empName);
							if(isValid)
							{
								nameflag = false;
							}
							else
							{
								System.out.println("Number must contain Characters only");
								nameflag = true;
							}
						}
					
						System.out.println("Enter Address:");
						String empAdd = sc.next();
					
						//Email Validation
						//--------------------------------------------------------------
						String empMailId=null;                   
						boolean flag=true;
						while(flag)														
						{
							System.out.println("Enter Email ID:");
							empMailId=sc.next();
							if(empMailId.contains(".com"))
								{
									flag = false;
								}
								else
								{
									System.out.println("Please Enter valid Mail Id");
									flag=true;
								}
						}
					
					//Mobile number Validation
					//-----------------------------------------------------------
					
						System.out.println("Enter Mobile Number:");
						long empMob = sc.nextLong();
						int length = String.valueOf(empMob).length();			
								while(length!=10)
								{
									System.out.println("Mobile number must contain 10 digit");	
									System.out.println("Enter Mobile Number:");
									empMob = sc.nextLong();
									length = String.valueOf(empMob).length();
								}
						System.out.println("Enter Department ID");
						int empDeptId = sc.nextInt();
						System.out.println("Enter Role ID");
						int empRoleId = sc.nextInt();
						System.out.println();
						
						Employee employee = new Employee(empId, empName, empAdd, empMailId, empMob, empDeptId, empRoleId);
						boolean isinsert = empDao.addEmployee(employee);
						if(isinsert) 
							System.out.println("record added Succesfully");
						else
							System.out.println("Unsuccesfull insertoin!!");
						break;
						
						
				//To Update Existing Employee
				case 2: System.out.println("Enter Employye ID To Update:");			
						int updateEmpId = sc.nextInt();
						
						//---Name validation start
						String newEmpName = null;
						boolean nameflag2=true;
						while(nameflag2)
						{
							System.out.println("Enter Employye Name:");
							newEmpName = sc.next();
							boolean isValid = empDao.NameValidation(newEmpName);
							if(isValid)
								{
									nameflag2 = false;
								}
							else
								{
									System.out.println("Number must contain Characters only");
									nameflag2 = true;
								}
						 }

						System.out.println("Enter New Address:");
						String newEmpAdd = sc.next();
						String newEmpMailId=null;                   
					
						//Email Validation
						boolean flag1 =true;
						while(flag1)														
						{
							System.out.println();
							System.out.println("LOG IN");
							System.out.println();
							System.out.println("Enter Email ID:");
							newEmpMailId=sc.next();
							if(newEmpMailId.contains(".com"))
							{
								flag1 = false;
							}
							else
							{
								System.out.println("Please Enter valid Mail Id");
								flag1=true;
							}
						}
					
						System.out.println("Enter New Mobile Number:");
						long newEmpMob = sc.nextLong();
						int length1 = String.valueOf(newEmpMob).length();		
						
						//mobile validation start
						while(length1!=10)												
						{
							System.out.println("Mobile number must contain 10 digit");	
							System.out.println("Enter Mobile Number:");
							newEmpMob = sc.nextLong();
							length1 = String.valueOf(newEmpMob).length();
						}

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
						
						
						
				//To delete record from employee table
				case 3:System.out.println("Enter Employee Id to Delete Employee Detail:");		
						int deleteEmpId =sc.nextInt();
						boolean isdelete = empDao.deleteEmployee(deleteEmpId);
						if(isdelete)
							System.out.println("Record deleted Successfully..");
						else
							System.out.println("unsuccesful deletion.");
						break;
						
						
						//Display All Employee record
				case 4:System.out.println("*************************************(Employee Detail)***********************************");
						
						List<Employee> empList = empDao.getAllEmployee();
						for(Employee emp:empList)
						{
							System.out.println("+--------------------------------------------------------------------------------------------------------------+");
							System.out.println("	EmployeeID : "+emp.getEmployeeId()+"\n	Employee Name : "+emp.getEmployeeName()+"\n	Address        :"+emp.getEmpAdress()+"\n	Mobile        :"+emp.getMobile()+"\n	DepatrmentID   : "+emp.getDeprtmentId()+" \n	RoleID        :"+emp.getRoleId()+" \n	Email ID      : "+emp.getEmail()+""	);
							System.out.println("+--------------------------------------------------------------------------------------------------------------+");
						}
						break;
						
						
						
				//To Search Employee detail by Department ID
				case 5: System.out.println("Enter  Id:");
						int dept_id = sc.nextInt();
						
						List<Employee> searchEmpList = empDao.searchEmployee(dept_id);
						for(Employee searchEmp:searchEmpList)
						{
							System.out.println("+--------------------------------------------------------------------------------------------------------------+");
							System.out.println("	EmployeeID : "+searchEmp.getEmployeeId()+" \n	Employee Name : "+searchEmp.getEmployeeName()+"\n	Address        "+searchEmp.getEmpAdress()+"\n	Mobile        :"+searchEmp.getMobile()+" \n	Email ID      : "+searchEmp.getEmail()+"\n	DepatrmentID   : "+searchEmp.getDeprtmentId()+" \n	RoleID        : "+searchEmp.getRoleId()+" ");
							System.out.println("+--------------------------------------------------------------------------------------------------------------+");
						}
						break;
						
						
				//Search API1
				case 6: Map<String,Integer> reportMap =empDao.getDepartmentwiseCount();
							System.out.println("******Deprtment wise Employee Report******");
							System.out.println();
						for(String reportSet:reportMap.keySet())
						{
							System.out.println("     DEPARTMENT NAME : "+reportSet+"\n     TOTAL EMPLOYEE : "+reportMap.get(reportSet));
							System.out.println("--------------------------------");
						}
						break;
						
						
				//API That search Employee detain having same Department Name:		
				case 7:System.out.println("Enter Department Name");
						String dept = sc.next();
						List<Employee> empBydeptList = empDao.getEmpByDepartmentName(dept);
						for(Employee empDept:empBydeptList)
						{
							System.out.println("+--------------------------------------------------------------------------------------------------------------+");
							System.out.println("	EmployeeID : "+empDept.getEmployeeId()+" \n	Employee Name : "+empDept.getEmployeeName()+"\n	Address        "+empDept.getEmpAdress()+"\n	Mobile        :"+empDept.getMobile()+" \n	Email ID      : "+empDept.getEmail()+"\n	DepatrmentID   : "+empDept.getDeprtmentId()+" \n	RoleID        : "+empDept.getRoleId()+" ");
							System.out.println("+--------------------------------------------------------------------------------------------------------------+");
						}
						break;
						
						
						
				case 8: System.out.println("Loged out....");
						runSwitch = false;
						break;
				}
				}while(runSwitch);
		}
		
		//Execute if Login Failed
		else
			{
				System.out.println("Authentication Failed");
			}
				
		}
		
}
