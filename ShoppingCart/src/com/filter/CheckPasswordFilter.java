// It is a filter for cheking the password
package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class CheckPasswordFilter implements Filter {

   
    public CheckPasswordFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		String username  = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.length()<6 || password.length()<6)
		{
			System.out.println("username or password length is less than 6");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
		else
		{
		chain.doFilter(request, response);
		}
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
