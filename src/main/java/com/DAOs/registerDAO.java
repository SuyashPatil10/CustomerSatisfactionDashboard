package com.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DAOs.Connect;

public class registerDAO {
	
	public int registerUser(String firstname, String lastname, String phone, String email, String password) 
	{	
		try 
		{
			Connect c = new Connect();
			Connection con = c.getConnection();
			
			String query1 = "select email, passwords from hotelUsers "
					+ "where email = ?";
			
			String query2 = "insert into hotelUsers values(?, ?, ?, ?, ?)";
			
			PreparedStatement pst1 = con.prepareStatement(query1);
			pst1.setString(1, email);
			
			ResultSet rs = pst1.executeQuery();
			
			int rowCount = 0;
			while(rs.next())
			{
				rowCount++;
			}
			
			if(rowCount > 0)
			{
				return 0;
			}
			else 
			{
				PreparedStatement pst2 = con.prepareStatement(query2);
				pst2.setString(1, firstname);
				pst2.setString(2, lastname);
				pst2.setString(3, email);
				pst2.setString(4, password);
				pst2.setString(5, phone);
				
				int result = pst2.executeUpdate();
				
				return result;
			}
		}
		catch(Exception e) 
		{
			return 0;
		}
		
	}
	
	
//	public static void main(String[] args)
//	{
//		registerDAO register = new registerDAO();
//		int result = register.registerUser("Soham", "Patil", "7768868601", "sohampatil266@gmail.com", "soham@266");
//		System.out.println(result);
//	}
	
	
}
