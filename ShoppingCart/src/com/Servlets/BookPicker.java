package com.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BookPicker extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList list= new ArrayList();;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();//when book is not available
		HttpSession session = request.getSession(false);
		String book = request.getParameter("booklist"); 
		list.add(book);
		session.setAttribute("book", list);
		System.out.println(list);
		RequestDispatcher rd = request.getRequestDispatcher("/CalPrice");
		rd.forward(request,response);
	}

}
