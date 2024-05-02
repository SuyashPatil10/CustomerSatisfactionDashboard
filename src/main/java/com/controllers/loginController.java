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
import com.DAOs.loginDAO;
/**
 * Servlet implementation class loginController
 */

@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		loginDAO login = new loginDAO();
		int validUser = login.logUser(email, password);
		
		RequestDispatcher rd;
		if(validUser == 1) 
		{
			Connect c = new Connect();
			ArrayList<String> al = (ArrayList<String>) c.getUserAttributes(email);
			HttpSession session = request.getSession();
			System.out.println(al);
			session.setAttribute("userInfo", al);
			
			rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
		else 
		{
			request.setAttribute("loginError", "Invalid Email and Password");
			rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}

}
