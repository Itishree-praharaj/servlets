package com.jsp.pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LogIn")
public class LoginServlet  extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html");
	PrintWriter out =res.getWriter();
	
	
	String userName = req.getParameter("userName");
	 String password = req.getParameter("pwd");
	 String name=req.getParameter("name");
	 
	 HttpSession session = req.getSession();
	 
	 if(userName.equals("user@gmail.com") && password.equals("1234")) {
		 session.setAttribute("name", name);
	 RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
	 out.println("Login sucessfull");
	 dispatcher.include(req, res);
}
	 else {
		 req.getRequestDispatcher("form.html").include(req,res);
		 out.println("Invalid credentials");
	 }
}
}