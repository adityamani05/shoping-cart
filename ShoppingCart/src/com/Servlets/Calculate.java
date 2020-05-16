package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Calculate extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	ArrayList l1;
	Connection con;
	
	public void init()
	{
		l1= new ArrayList();
		con =(Connection) getServletConfig().getServletContext().getAttribute("dbcon");
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int totalprice = 0;
		PrintWriter out = response.getWriter();
		out.println("in calculate");
		HttpSession session = request.getSession(false);
		l1=(ArrayList) (session.getAttribute("book"));
		Iterator i = l1.iterator();
		while(i.hasNext())
		{
			String s = (String) i.next();
			try {
				PreparedStatement psmt = con.prepareStatement("select * from bookprice where bookname = ?");
				psmt.setString(1, s);
				ResultSet rs =psmt.executeQuery();
				while(rs.next())
				{
					String bname = rs.getString(1);
					int amt = rs.getInt(2);
					int no = rs.getInt(3);
					if(no>0)
					{
						totalprice = totalprice+amt;
					}
					else
					{
						out.println(bname+"Book not available");
						System.out.println(bname+"Book not available");
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		System.out.println(l1);
		System.out.println("Total Price:"+totalprice );
		out.println(l1);
		//System.out.println(l1);
		//System.out.println("1700®");
		out.println("<br><br>");
		out.println(" <a herf=''> logout </a>");
		RequestDispatcher rd = request.getRequestDispatcher("/Inval");
		rd.forward(request, response);
		
	}

}
