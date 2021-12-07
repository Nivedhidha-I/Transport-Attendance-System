package com.transport;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Feedback extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log","root","");
		
		String id = request.getParameter("id");
		int rate = Integer.parseInt(request.getParameter("rate"));
		String feed = request.getParameter("feed");
		
		
		String str = "insert into feed (uniqueid,rating,feedback) values ('"+id+"',"+"'"+rate+"',"+"'"+feed+"')";
		Statement stat = con.createStatement();
		stat.executeUpdate(str);
		
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
		response.sendRedirect("feedback.jsp");
	}

}
