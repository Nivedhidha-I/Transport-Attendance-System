package com.transport;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditInfo extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	String Username = (String) session.getAttribute("Username");
	String name = request.getParameter("name");
	String mobile = request.getParameter("mobile");
	String pass = request.getParameter("pass");
	try{
//		Creating a connection
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log", "root", "");
		String str = "UPDATE passenger_info SET Passenger_Name='" + name + "', Mobile='" + mobile + "', Password='" + pass + "' WHERE Unique_ID='" + Username + "';";
		Statement stat = con.createStatement();
		stat.executeUpdate(str);
		stat.close();
		con.close();
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	response.sendRedirect("updated_successfully.jsp");
}
}
