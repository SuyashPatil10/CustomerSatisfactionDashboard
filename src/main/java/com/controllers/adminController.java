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

import com.DAOs.Connect;
import com.DAOs.adminDAO;

@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		adminDAO login = new adminDAO();
		int validUser = login.logAdmin(email, password);
		
		RequestDispatcher rd;
		if(validUser == 1) 
		{
			Connect c = new Connect();
			ArrayList<String> al = (ArrayList<String>) c.getAdminAttributes(email);
			System.out.println(al);
			HttpSession session = request.getSession();
			session.setAttribute("adminInfo", al);
			
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		else 
		{
			request.setAttribute("loginError", "Invalid Email and Password");
			rd = request.getRequestDispatcher("/admin.jsp");
			rd.include(request, response);
		}
	}

}
