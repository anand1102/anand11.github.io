package com.cognizant.edialgonsis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cognizant.edialgonsis.util.DbConnector;

public class UserDAO {
	public boolean validateUser(String username,String password)
	{
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		boolean result=false;
		try
		{
			conn=DbConnector.getConnection();
			st=conn.prepareStatement("select * from users where username=? and password=?");
		st.setString(1, username);
		st.setString(2, password);
		rs=st.executeQuery();
		if(rs.next())
			result=true;
		}
		catch(Exception e )
		{
		e.printStackTrace();
	}
		return result;
}
}
