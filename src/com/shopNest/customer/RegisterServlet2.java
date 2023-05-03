package com.shopNest.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopNest.dbHandler.DataInjector;

public class RegisterServlet2 extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=req.getParameter("uname");
		String email=req.getParameter("email");
		String psw=req.getParameter("password");
		String gender=req.getParameter("gender");	
		String address=req.getParameter("address");
		String status=DataInjector.addCustomer(uname,email,psw,gender,address);
		if(status=="success")
		{
		res.sendRedirect("login.jsp");
		}
		else
		{
			res.sendRedirect("register.jsp");
		}
		
	}

}
