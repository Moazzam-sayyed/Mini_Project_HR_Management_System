package com.dao;

import com.model.Employee;
import com.configuration.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			pst.setLong(4,employee.getMobile());
			pst.setInt(5, employee.getDeprtmentId());
			pst.setInt(6,employee.getRoleId());
			pst.setString(7, employee.getEmail());
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
			pst.setLong(3,updateEmployee.getMobile());
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

	//To Get all Table data
	@Override
	public List<Employee> getAllEmployee() {
		ArrayList<Employee> employeeList = new ArrayList<>();
		try(Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement("select * from employee"))
		{
			
			ResultSet rs= pst.executeQuery();
			while(rs.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setEmpAdress(rs.getString(3));
				employee.setMobile(rs.getLong(4));
				employee.setDeprtmentId(rs.getInt(5));
				employee.setRoleId(rs.getInt(6));
				employee.setEmail(rs.getString(7));
				employeeList.add(employee);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeList;
	}
	@Override
	public List<Employee> searchEmployee(int searchId) {
			ArrayList<Employee> searchList = new ArrayList<>();
				try(Connection con =ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement("select * from employee where department_id=?"))
			{
				pst.setInt(1, searchId);
				ResultSet rs = pst.executeQuery();
				while(rs.next())
				{
					Employee employee = new Employee();
					employee.setEmployeeId(rs.getInt(1));
					employee.setEmployeeName(rs.getString(2));
					employee.setEmpAdress(rs.getString(3));
					employee.setMobile(rs.getLong(4));
					employee.setDeprtmentId(rs.getInt(5));
					employee.setRoleId(rs.getInt(6));
					employee.setEmail(rs.getString(7));
					searchList.add(employee);
					return searchList;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return null;
		}

	@Override
	public Map<String, Integer> getDepartmentwiseCount() {
		HashMap<String,Integer> reportMap = new HashMap<>();
		try(Connection con=ConnectionFactory.getConnection();
				Statement st = con.createStatement())
		{
			ResultSet rs = st.executeQuery("select d.department_name ,count(*) from department d inner join employee e on e.department_id = d.department_id group by department_name");
			
			while(rs.next()) {
				reportMap.put(rs.getString(1),rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportMap;
	}
	}

