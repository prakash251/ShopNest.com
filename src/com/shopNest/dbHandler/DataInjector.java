package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataInjector {

	public static String addCustomer(String uname, String email, String psw, String gender, String address) 
	{

		String driver="oracle.jdbc.driver.OracleDriver";
		String un="system";
		String pss="0539";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection con=null;
		PreparedStatement pstmt=null;
		String query="insert into customers values(?,?,?,?,?)";
		String regStatus="";
		try {
			Class.forName(driver);
			con =DriverManager.getConnection(url, un, pss);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,uname);
			pstmt.setString(2,email);
			pstmt.setString(3,psw);
			pstmt.setString(4,gender);
			pstmt.setString(5,address);
			pstmt.executeUpdate();
			regStatus="success";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("problem in adding customer");
			regStatus="fail";
		}
		finally
		{
			return regStatus;
		}
	}

	public static boolean addProduct(int pid, String pname, String pdesc, int pprice, String pimg) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="0539";
		String sql="INSERT INTO products VALUES(?,?,?,?,?)";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, user, password);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pdesc);
			ps.setInt(4, pprice);
			ps.setString(5, pimg);
			ps.executeUpdate();
		}catch(Exception e){
			System.out.println("Problem in adding product");
			e.printStackTrace();
			return false;
		}			
		return true;
	}
}




