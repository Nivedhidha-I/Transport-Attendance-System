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

public class InsertAcc extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.include(request, response);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log","root","");
			
			String unq = request.getParameter("iuid");
			String name = request.getParameter("name");
			String dept = request.getParameter("dept");
			String occ = request.getParameter("occ");
			String mob = request.getParameter("mobile");
			String bus = request.getParameter("bid");
			String fee = request.getParameter("fee");
			String pas = request.getParameter("pass");
			
			String str = "INSERT INTO passenger_info (Unique_ID, Passenger_Name,Occupation, Department, Mobile, Bus_ID, Fee, Password) values ('"+unq+"',"+"'"+name+"',"+"'"+occ+"',"+"'"+dept+"',"+"'"+mob+"',"+"'"+bus+"',"+"'"+fee+"',"+"'"+pas+"')";
			Statement stat = con.createStatement();
			stat.executeUpdate(str);
			response.sendRedirect("inserted.jsp");
			
		}catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
}
