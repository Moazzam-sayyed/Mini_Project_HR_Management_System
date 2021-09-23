package com.dao;
import com.model.*;
import com.configuration.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.configuration.ConnectionFactory;


public class UserDaoImplementation implements UserDao{
	public boolean authentication()
	{
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement("select * from user"))
		{
		 ResultSet rs= pst.executeQuery(); 
		 while(rs.next())
		 {
			 User user = new User();
			 user.setUsername(rs.getString(2));
			 user.setPassword(rs.getString(3));
		 }
		 return true;
		}
		catch (SQLException e) {
		// TODO: handle exception
	}
		return false;
	}

}
