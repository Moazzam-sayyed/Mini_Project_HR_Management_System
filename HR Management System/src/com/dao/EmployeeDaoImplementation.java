package com.dao;

import com.model.Employee;
import com.configuration.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDaoImplementation implements EmployeeDao{

	//Add Employee detail on database through DAO Implementation
	@Override
	public boolean addEmployee(Employee employee) {				
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement pst= con.prepareStatement("insert into employee  values(?,?,?,?,?,?,?)"))
		{
			pst.setInt(1,employee.getEmployeeId());
			pst.setString(2,employee.getEmployeeName());
			pst.setString(3,employee.getEmpAdress());
			pst.setInt(4,employee.getMobile());
			pst.setInt(5, employee.getDeprtmentId());
			pst.setInt(6,employee.getRoleId());
			pst.setInt(7, employee.getRoleId());
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//Update Employee Detail
	@Override
	public boolean updateEmployee(Employee updateEmployee) {				
		try(Connection con=ConnectionFactory.getConnection();
				PreparedStatement pst= con.prepareStatement("update employee set ename=?,address=?,mobile=?,department_id=?,role_id=?,email_id=? where empid=?"))
		{

			pst.setString(1, updateEmployee.getEmployeeName());
			pst.setString(2,updateEmployee.getEmpAdress());
			pst.setInt(3,updateEmployee.getMobile());
			pst.setInt(4, updateEmployee.getDeprtmentId());
			pst.setInt(5,updateEmployee.getRoleId());
			pst.setString(6, updateEmployee.getEmail());
			pst.setInt(7, updateEmployee.getEmployeeId());
			pst.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {						//Delete database record containing given ID
		try(Connection con =ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement("delete from employee where empid=?"))
				{
					pst.setInt(1, id);
					pst.executeUpdate();
					return true;
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
		return false;
	}

	@Override
	public List<Employee> getAllEmployee() {
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement("Select * from employee"))
		{
			ArrayList<Employee> EmployeeList = new ArrayList<>();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
