<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<form action="insertion" method ="post">
<h1>Create New Account</h1>
Enter Unique ID: <input type="text" name="iuid"><br><br>
Enter Name: <input type="text" name="name"><br><br>
Enter Department: <input type="text" name="dept"><br><br>
Enter Occupation: <input type="text" name="occ"><br><br>
Enter Mobile Number: <input type="text" name="mobile"><br><br>
Enter Bus_ID: <input type="number" name="bid"><br><br>
Enter Fee: <input type="text" name="fee"><br><br>
Enter Password: <input type="password" name="pass"><br/><br/>
<button type="submit">Submit</button>


</form><br/><br/>
<h1>Delete Account</h1>
<form action="deletion" method="post">
Enter UniqueID: <input type="text" name="duid"><br/><br/>
<button type="submit">Delete</button>
</form><br/><br/>

<h1>Passenger Details</h1>
<% 
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/transportation_log","root","");
	System.out.print("Connected");
	String str1 ="SELECT * FROM passenger_info";
	Statement stat1 = con.createStatement();
	ResultSet rs = stat1.executeQuery(str1);
	out.print("<table>");
	out.print("<tr>");
	out.print("<th>UniqueID</th>");
	out.print("<th>Name</th>");
	out.print("<th>Occupation</th>");
	out.print("<th>Department</th>");
	out.print("<th>Mobile Number</th>");
	out.print("<th>Bus_ID</th>");
	out.print("<th>Fee</th>");
	out.print("<th>Password</th>");
	out.print("</tr>");
	while(rs.next())
	{
		out.print("<tr>");
		out.print("<td>");
		out.print(rs.getString("Unique_ID"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Passenger_Name"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Occupation"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Department"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Mobile"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Bus_ID"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Fee"));
		out.print("</td>");
		out.print("<td>");
		out.print(rs.getString("Password"));
		out.print("</td>");
		out.print("</tr>");
		
	}
	
	out.print("</table>");
	
}catch(Exception e)
{
	System.out.print(e.getMessage());
}
%>
</body>
</html>