package com.controller;
import com.dao.EmployeeDao;
import com.model.*;
import com.dao.EmployeeDaoImplementation;
import com.dao.UserDao;
import com.dao.UserDaoImplementation;
import com.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicStampedReference;;

public class Client {
	
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDaoImplementation();
		UserDao userdao = new UserDaoImplementation();
		
		Scanner sc= new Scanner(System.in);
		User user = new User();

		System.out.println("Enter Usern Name");
		String enterUser = sc.next();
		System.out.println("Enter Password");
		String enterPassword = sc.next();
		
		
		boolean checkAuthentication = userdao.authentication();
		String MainUser = user.getUsername();
		String passweord = user.getPassword();
		
		
		
		
		
		
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
		System.out.println("					 |  7	| Exit                          |");
		System.out.println("					 +--------------------------------------+");
		System.out.println("					 | Please Enter Your Choice		|");

		int choice = sc.nextInt();
		
		
			switch(choice)
			{
			case 1: System.out.println("Enter Employye ID:");		//To add new employee
				int empId = sc.nextInt();
				System.out.println("Enter Employye Name:");
				String empName = sc.next();
				System.out.println("Enter Address:");
				String empAdd = sc.next();
				System.out.println("Enter Email ID:");
				String empMailId = sc.next();
				System.out.println("Enter Mobile Number:");
				long empMob = sc.nextLong();
				int length = String.valueOf(empMob).length();			//Mobile number validation
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
				
				
			case 2: System.out.println("Enter Employye ID To Update:");			//To Update Existing Employee
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
				
			case 3:System.out.println("Enter Employee Id to Delete Employee Detail:");		//To delete record from employee table
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
					//
					break;
					
					
					//To Search Employee detail by Department ID
					
			case 5: System.out.println("Enter dept Id:");
					int empid = sc.nextInt();
					
					List<Employee> searchEmpList = empDao.searchEmployee(empid);
					for(Employee searchEmp:searchEmpList)
					{
						System.out.println("+--------------------------------------------------------------------------------------------------------------+");
						System.out.println("	EmployeeID : "+searchEmp.getEmployeeId()+" \\n	Employee Name : "+searchEmp.getEmployeeName()+"\\n	Address        "+searchEmp.getEmpAdress()+"\\n	Mobile        :"+searchEmp.getMobile()+" \n	Email ID      : "+searchEmp.getEmail()+"\\n	DepatrmentID   : "+searchEmp.getDeprtmentId()+" \\n	RoleID        : "+searchEmp.getRoleId()+" ");
						System.out.println("+--------------------------------------------------------------------------------------------------------------+");
					}
					break;
			
			case 6: Map<String,Integer> reportMap =empDao.getDepartmentwiseCount();
					for(String reportSet:reportMap.keySet()) {
						System.out.println(" "+reportSet+" | "+reportMap.get(reportSet));
					}
					break;
			
			case 7:System.out.println("Thankyou....");
					break;
				}
				}while(true);
	
				
		}
}
