<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String num1 = request.getParameter("num1");
String num2 = request.getParameter("num2");

String operation = request.getParameter("operation"); 
if(operation.equals("addition")) {
	out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
}
	
	else if(operation.equals("subtraction")) {
		out.println(Integer.parseInt(num1) - Integer.parseInt(num2));
	}
		
		else if(operation.equals("mulitiplication")) {
			out.println(Integer.parseInt(num1) * Integer.parseInt(num2));
		}
			
		else {
			
				out.println(Integer.parseInt(num1) / Integer.parseInt(num2));
			}
%>
</body>
</html>