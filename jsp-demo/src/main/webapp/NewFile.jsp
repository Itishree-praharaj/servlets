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
System.out.println("hello world");
m1();
System.out.println(a);
%>
<%!
public void m1() {
	System.out.println("Good evening");
}
static int a=10;    
%>

</body>
</html>