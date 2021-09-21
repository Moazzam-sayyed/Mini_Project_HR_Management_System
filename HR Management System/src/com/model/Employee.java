package com.model;

public class Employee {
	private int employeeId;
	private String employeeName;
	private String empAdress;
	private String email;
	private int mobile;
	private int deprtmentId;
	private int roleId;
	
	public Employee()
	{
		
	}
	//parameterized constructor
	public Employee(int employeeId, String employeeName, String empAdress, String email, int mobile, int deprtmentId,
			int roleId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.empAdress = empAdress;
		this.email = email;
		this.mobile = mobile;
		this.deprtmentId = deprtmentId;
		this.roleId = roleId;
	}

	
	//Geter Seter methods
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmpAdress() {
		return empAdress;
	}

	public void setEmpAdress(String empAdress) {
		this.empAdress = empAdress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public int getDeprtmentId() {
		return deprtmentId;
	}

	public void setDeprtmentId(int deprtmentId) {
		this.deprtmentId = deprtmentId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", empAdress=" + empAdress
				+ ", email=" + email + ", mobile=" + mobile + ", deprtmentId=" + deprtmentId + ", roleId=" + roleId
				+ "]";
	}
	 

	

	
}
