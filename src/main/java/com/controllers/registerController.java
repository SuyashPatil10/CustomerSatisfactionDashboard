package com.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.util.ArrayList;
import com.DAOs.registerDAO;
import com.DAOs.Connect;
/**
 * Servlet implementation class registerController
 */

@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone  = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		registerDAO register = new registerDAO();
		int result = register.registerUser(firstname, lastname, phone, email, password);
		
		RequestDispatcher rd;
		
		if(result == 1) 
		{
			Connect c = new Connect();
			ArrayList<String> al = c.getUserAttributes(email);
			
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", al);
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		else 
		{
			request.setAttribute("registerError", "User Already Exists");
			rd = request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
		}
	}

}
