package com.shopNest.customer;

import com.shopNest.dbHandler.DataFetcher;

public class Validator {

	public static boolean isValid(String uname, String psw) 
	{
		String pass=DataFetcher.fetchPass(uname,psw);
		System.out.println(pass+"..."+psw);
		if(pass.equals(psw))
		{
			return true;

		}
		else
		{
			return false;
		}

	}
}
