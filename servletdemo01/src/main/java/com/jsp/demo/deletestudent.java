package com.jsp.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deletestudent")
public class deletestudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String id = req.getParameter("id");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
			PreparedStatement ps = con.prepareStatement("delete from student1 where id=?");
			ps.setInt(1, Integer.parseInt(id));
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			PrintWriter pw = resp.getWriter();
			pw.println(rs.getInt(1));
			pw.println(rs.getString(2));
			pw.println(rs.getInt(3));
			pw.println(rs.getInt(4));
			pw.println(rs.getInt(5));
			
			
			System.out.println("data deleted");
			
		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}

}
