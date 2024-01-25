package com.jsp.demo;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	@WebServlet("/deletestu")
	public class deletestudent extends HttpServlet{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id = req.getParameter("id");
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "root");
					 PreparedStatement ps = con.prepareStatement("delete from student1 where id=?");
					 ps.setInt(1, Integer.parseInt(id));
					
					 
					 ps.executeUpdate();
					 
					 PrintWriter pw = resp.getWriter();
					 pw.println("Data Deleted Successfully");
					 
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				
				
			
		}

	}


