package com.DAOs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class JsonDAO {
	
	public JsonArray getJSONData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tcs", "root", "suyash@1823");
			String query = "select * from feedback";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			JsonDAO json = new JsonDAO();
			JsonArray jsonData = json.prepareJSON(rs);

			
//			rs.close();
//			pst.close();
//			con.close();
			
//			System.out.println(jsonData);
			
			return jsonData;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private JsonArray prepareJSON(ResultSet rs) {
		try {
			JsonArray jsonArray = new JsonArray();
			
			while(rs.next()) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("id", rs.getInt(1));
				jsonObject.addProperty("name", rs.getString(2));
				jsonObject.addProperty("gender", rs.getString(3));
				jsonObject.addProperty("country", rs.getString(4));
				jsonObject.addProperty("state", rs.getString(5));
				jsonObject.addProperty("city", rs.getString(6));
				jsonObject.addProperty("wifi_service", rs.getInt(7));
				jsonObject.addProperty("arrival_convinience", rs.getInt(8));
				jsonObject.addProperty("online_booking", rs.getInt(9));
				jsonObject.addProperty("food", rs.getInt(10));
				jsonObject.addProperty("comfort", rs.getInt(11));
				jsonObject.addProperty("entertainment", rs.getInt(12));
				jsonObject.addProperty("checkout_service", rs.getInt(13));
				jsonObject.addProperty("clean", rs.getInt(14));
				jsonObject.addProperty("other", rs.getInt(15));
				jsonObject.addProperty("location", rs.getInt(16));
				jsonObject.addProperty("status", rs.getString(17));
				jsonArray.add(jsonObject);
			}
			return jsonArray;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public static void main(String[] args) {
//		JsonDAO json = new JsonDAO();
//		JsonArray jsonData = json.getJSONData();
//		System.out.println(jsonData);
//	}
}
