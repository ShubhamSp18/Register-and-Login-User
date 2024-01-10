package com.register;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.apache.catalina.startup.UserDatabase;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try 
		{
			PrintWriter out = response.getWriter();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AugustBatch","root","Shubham@18");
			
			String n = request.getParameter("username");
			String p = request.getParameter("password");
			String e = request.getParameter("email");
			
			PreparedStatement ps = con.prepareStatement("insert into Register3(username,password,email) values(?,?,?)");
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			
			int cnt = ps.executeUpdate();
			
			if(cnt>0)
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
				rd.forward(request, response);
			}
		} 
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
		}
	}

}
