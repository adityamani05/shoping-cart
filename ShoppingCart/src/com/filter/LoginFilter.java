package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class LoginFilter implements Filter {

    
    public LoginFilter()
    {
    	
    }

	public void destroy()
	{
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		String uname = request.getParameter("username");
		if(uname.endsWith("@gmail.com"))
		{
			request.setAttribute("username", uname);
		}
		else
		{
			uname = uname+"@gmail.com";
			request.setAttribute("username", uname);
		}
		
		System.out.println("in Filter");
		chain.doFilter(request, response);
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}

}
