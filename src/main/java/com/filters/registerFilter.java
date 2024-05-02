package com.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import com.filters.Validation;

/**
 * Servlet Filter implementation class registerFilter
 */
@WebFilter("/registerController")
public class registerFilter extends HttpFilter implements Filter {
       
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone  = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Validation v = new Validation();
		RequestDispatcher rd;
		
		if((firstname != null) && (firstname.length() < 50) && (firstname != ""))
		{
			if((lastname != null) && (lastname.length() < 50) && (lastname != ""))
			{
				if(v.checkEmailPattern(email))
				{
					if(v.checkPhoneNumber(phone))
					{
						if(v.checkPasswordPattern(password))
						{
							chain.doFilter(request, response);
						}
						else
						{
							request.setAttribute("registerError", "Password must be 8 characters long <br> "
									+ "with at least one Uppercase character, <br>" + 
									" one special character and one One number");
							rd = request.getRequestDispatcher("/register.jsp");
							rd.include(request, response);
						}
					}
					else
					{
						request.setAttribute("registerError", "Invalid Phone number!");
						rd = request.getRequestDispatcher("/register.jsp");
						rd.include(request, response);
					}
				}
				else
				{
					request.setAttribute("registerError", "Invalid Email Address!");
					rd = request.getRequestDispatcher("/register.jsp");
					rd.include(request, response);
				}
			}
			else
			{
				request.setAttribute("registerError", "Please enter lastname within 50 characters!");
				rd = request.getRequestDispatcher("/register.jsp");
				rd.include(request, response);
			}
		}
		else
		{
			request.setAttribute("registerError", "Please enter firstname within 50 characters!");
			rd = request.getRequestDispatcher("/register.jsp");
			rd.include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
