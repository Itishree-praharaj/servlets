package com.jsp.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addstudent")
public class addstudent extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String yop = req.getParameter("yop");
		String age = req.getParameter("age");
		String mobilenumber = req.getParameter("mobilenumber");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into student1 values (?,?,?,?,?)");
			ps.setInt(1, Integer.parseInt(id));
			ps.setString(2, name);
			ps.setInt(3, Integer.parseInt(yop));
			ps.setInt(4, Integer.parseInt(age));
			ps.setInt(5, Integer.parseInt(mobilenumber));
			
			ps.execute();
			
			System.out.println("data added");
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
		
	}
}
