package com.shopNest.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet2 extends HttpServlet {


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String uname=req.getParameter("uname");
		String psw= req.getParameter("pass");
		boolean valid=Validator.isValid(uname,psw);
		System.out.println(valid);
		if(valid==true && uname.equals("admin"))
		{
			res.sendRedirect("admin.jsp");

		}
		else if(valid==true)
		{
			res.sendRedirect("home.jsp");
		}
		else
		{
			res.sendRedirect("login.jsp");
		}

	}

}
