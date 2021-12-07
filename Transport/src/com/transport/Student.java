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

public class Student extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String Username = (String) session.getAttribute("Username");
		response.setContentType("text/html");
		try{
//			Creating a connection
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log", "root", "");
//			Getting user&pass of each passengers
			String str = "SELECT * FROM passenger_info";
			Statement stat = con.createStatement();
			ResultSet Passengers = stat.executeQuery(str);
			while(Passengers.next()){
				String uid = Passengers.getString("Unique_ID");
				if(Username.equals(uid)){
					String pname = Passengers.getString("Passenger_Name");
					String dept = Passengers.getString("Department");
					String occ = Passengers.getString("Occupation");
					String mobile = Passengers.getString("Mobile");
					String bid = Passengers.getString("Bus_ID");
					String fee = Passengers.getString("Fee");
					String pass = Passengers.getString("Password");
					out.print("<!DOCTYPE html>");
					out.print("<html><head><title>Student Form</title></head><body>");
					out.print("<h1 style='text-align:center;'>Student Info</h1>");
					out.print("<form action='EditInfo' method='post'><table>");
					out.print("<tr><td>Unique ID: </td><td> " + uid + " </td></tr>");
					out.print("<tr><td>Name: </td><td> <input type='text' value='" + pname + "' name='name'/> </td></tr>");
					out.print("<tr><td>Department: </td><td> " + dept + " </td></tr>");
					out.print("<tr><td>Occupation: </td><td> " + occ + " </td></tr>");
					out.print("<tr><td>Mobile: </td><td> <input type='tel' value='" + mobile + "' name='mobile'/> </td></tr>");
					out.print("<tr><td>Bus Number: </td><td> " + bid + " </td></tr>");
					out.print("<tr><td>Fee: </td><td> " + fee + " </td></tr>");
					out.print("<tr><td>Password: </td><td> <input type='password' value='" + pass + "' name='pass'/> </td></tr>");
					out.print("<tr style='text-align:center;'><td colspan='2'> <input type='submit' value='S U B M I T'/> </td></tr>");
					out.print("</table></form></body></html>");
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
}
