package com.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adminDAO {
	public int logAdmin(String email, String password)
	{	
		try {
			Connect c = new Connect();
			
			Connection con = c.getConnection();
			
			String query = "select email, passwords from admins "
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
}
