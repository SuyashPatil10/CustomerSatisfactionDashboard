package com.DAOs;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DAOs.Connect;

public class loginDAO {
	
	public int logUser(String email, String password)
	{	
		try {
			Connect c = new Connect();
			
			Connection con = c.getConnection();
			
			String query = "select email, passwords from hotelUsers "
					+ "where email = ? AND passwords = ?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			
			int rowCount = 0;
			while(rs.next())
			{
				rowCount++;
			}
			
			return rowCount;
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			return 0;
		}
	}
	
//	public static void main(String[] args) {
//		loginDAO ld = new loginDAO();
//		int value = ld.logUser("813suyash@gmail.com", "suyash@1823");
//		System.out.println(value);
//	}
}