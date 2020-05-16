package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class loginvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	public void init()
	{
		
		con = (Connection) getServletConfig().getServletContext().getAttribute("dbcon");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String pas;
		PrintWriter out = response.getWriter();
		String uname = (String) request.getAttribute("username");
		String pass = request.getParameter("password");
		
		try {
			psmt = con.prepareStatement("Select * from bookuser where username=?");
			psmt.setString(1, uname);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				 pas = rs.getString(2);
				 if(pass.equals(pas))
					{
						HttpSession session = request.getSession(true);
						String sessionid = session.getId();
						System.out.println("id is" + sessionid);
						RequestDispatcher rd = request.getRequestDispatcher("/shopbook.html");
						rd.forward(request, response);
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("/login.html");
						rd.include(request, response);
						out.println("INVALID USERNAME OR PASSWORD");
					}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
	}

}
