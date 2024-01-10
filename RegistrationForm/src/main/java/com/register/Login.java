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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			PrintWriter out = response.getWriter();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AugustBatch","root","Shubham@18");
			
			String n = request.getParameter("username");
			String p = request.getParameter("password");
			//String e = request.getParameter("email");
			
			PreparedStatement ps = con.prepareStatement("select * from Register3 where username=? and password=?");
			ps.setString(1, n);
			ps.setString(2, p);
		//	ps.setString(3, e);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.jsp");
				rd.forward(request, response);
			}
			else
			{
				out.print("<h3>New User Resgister First</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("Register3.jsp");
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
