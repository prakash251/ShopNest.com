package com.shopNest.dbHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shopNest.product.Product;

public class DataFetcher {

	public static String fetchPass(String uname, String psw)
	{

		String driver="oracle.jdbc.driver.OracleDriver";
		String un="system";
		String pss="0539";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet res=null;
		String query="select psw from customers where uname=?";
		String dbPass="";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, un, pss);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,uname);
			res=pstmt.executeQuery();
			res.next();
			dbPass=res.getString(1);
		//	System.out.println(dbPass);
		}
		catch (Exception e) {
			System.out.println("password not there");
			e.printStackTrace();
		}	
		return dbPass;
	}
	public static List fetchUsersInfo()
	{
		
		String driver="oracle.jdbc.driver.OracleDriver";
		String un="system";
		String pss="0539";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		Connection con=null;
        Statement stmt=null;
		ResultSet rs=null;
		List uslist=new ArrayList();
		String query="select uname,email,gender,address from customers";
	
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, un, pss);
			
			stmt=con.createStatement();
		    rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				String temp=rs.getString(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getString(4);
				uslist.add(temp);
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("login fail");
			e.printStackTrace();
		}	
		
		return uslist;
		
	}
	
public static List fetchProductsInfo()
{
	String driver="oracle.jdbc.driver.OracleDriver";
	String un="system";
	String pss="0539";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	Connection con=null;
    Statement stmt=null;
	ResultSet rs=null;
	List pdlist=new ArrayList();
	String query="select pid,pname,pdesc,pprice,pimg from PRODUCTS";

	try {
		Class.forName(driver);
		con=DriverManager.getConnection(url, un, pss);
		
		stmt=con.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next())
		{
			String temp=rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3)+":"+rs.getInt(4)+":"+rs.getString(5);
			pdlist.add(temp);
		}
		
	}
	catch (Exception e) 
	{
		System.out.println("login fail");
		e.printStackTrace();
	}	
	
	return pdlist;
	
}
public static Product getProductById(int pid) {
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="0539";
	String sql="SELECT pname,pprice FROM products WHERE pid=?";
	Product p=null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url, user, password);
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, pid);
		ResultSet rs=ps.executeQuery();
		rs.next();
		String pname=rs.getString(1);
		int pprice=rs.getInt(2);
		
		p=new Product(pid,pname,pprice);
	}catch(Exception e){
		System.out.println("Problem in fetching product by id");
		e.printStackTrace();
	}			
	finally {
		return p;
	}
}

}
