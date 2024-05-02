package com.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/feedbackController")
public class feedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("first-name");
		String lastName = request.getParameter("last-name");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		String wifiService = request.getParameter("wifi");
		String onlineBooking = request.getParameter("online-booking");
		String food = request.getParameter("food");
		String comfort = request.getParameter("comfort");
		String checkout = request.getParameter("checkout");
		String clean = request.getParameter("clean");
		String other = request.getParameter("other");
		String overall = request.getParameter("overall");
		
		
	}

}
