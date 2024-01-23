<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
PreparedStatement ps = con.prepareStatement("delete from student where id=?");
ps.setInt(1,Integer.parseInt(id));
ps.execute();

RequestDispatcher rd = request.getRequestDispatcher("fetchallstudent.jsp");
rd.forward(request, response); 
%>
</body>
</html>