package com.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import com.filters.Validation;
/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/loginController")
public class loginFilter extends HttpFilter implements Filter {
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Validation v = new Validation();
		RequestDispatcher rd;
		
		if((v.checkEmailPattern(email)) && (email != null) && (email != ""))
		{
			if((v.checkPasswordPattern(password)) && (password != null) && (password != ""))
			{
				chain.doFilter(request, response);
			}
			else
			{
				request.setAttribute("loginError", "Password must be 8 characters long <br> "
						+ "with at least one Uppercase character, <br>" + 
						" one special character and one One number");
				rd = request.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
		}
		else
		{
			request.setAttribute("loginError", "Invalid Email Address!");
			rd = request.getRequestDispatcher("/login.jsp");
			rd.include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
