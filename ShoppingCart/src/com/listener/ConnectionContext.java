package com.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class ConnectionContext implements ServletContextListener 
{
	Connection con;
   
    public void contextInitialized(ServletContextEvent ctx)  
    { 
         ServletContext context = ctx.getServletContext();
         String driver = context.getInitParameter("driver");
         String url = context.getInitParameter("url");
         String username = context.getInitParameter("username");
         String password = context.getInitParameter("password");
         
         
         try {
        	 Class.forName(driver);
			con=DriverManager.getConnection(url,username,password);
		} 
         catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         context.setAttribute("dbcon", con);
         
    }
	
    public void contextDestroyed(ServletContextEvent sce) 
    { 
         try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
