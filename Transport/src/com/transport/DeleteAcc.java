package com.transport;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAcc extends HttpServlet{
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
		rd.include(request, response);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log","root","");
			String unqid= request.getParameter("duid");
			String str = "DELETE FROM passenger_info WHERE Unique_ID = ('"+unqid+"') ";
			Statement stat = con.createStatement();
			stat.executeUpdate(str);
			response.sendRedirect("deleted.jsp");
		}catch(Exception e)
		{
			System.out.print("\n"+e.getMessage());
		}
	}
}
