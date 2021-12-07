package com.transport;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String Username = request.getParameter("user");
		String Password = request.getParameter("pass");
		int valid = 0;
		if(Username.equals("admin") && Password.equals("admin")){
			session.setAttribute("Username", Username);
			response.sendRedirect("Admin.jsp");
			valid = 1;
		}
		else{
			try{
//				Creating a connection
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log", "root", "");
//				Getting user&pass of each passengers
				String str = "SELECT Unique_ID, Password FROM passenger_info";
				Statement stat = con.createStatement();
				ResultSet Passengers = stat.executeQuery(str);
				while(Passengers.next()){
					if(Username.equals(Passengers.getString("Unique_ID")) && Password.equals(Passengers.getString("Password"))){
						session.setAttribute("Username", Username);
						valid = 1;
						response.sendRedirect("Student");
						break;
					}	
				}
				Passengers.close();
				stat.close();
				con.close();
			} catch(Exception e) {
				System.out.print(e.getMessage());
			}
		}
		if(valid==0){
			response.sendRedirect("login_invalid.jsp");
		}
	}
}
