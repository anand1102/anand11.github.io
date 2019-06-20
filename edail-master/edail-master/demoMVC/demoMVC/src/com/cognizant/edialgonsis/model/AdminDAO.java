package com.cognizant.edialgonsis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cognizant.edialgonsis.util.DbConnector;

public class AdminDAO {

	public boolean validateUser(String username, String password) {
		{
		       Connection conn=null;
		       PreparedStatement st=null;
		       ResultSet rs=null;
		       boolean result=false;
		       
		       try
		       {
		           conn=DbConnector.getConnection();
		           st=conn.prepareStatement("select * from admin where email_id=? and password=?");
		            st.setString(1, username);
		           st.setString(2, password);
		           rs=st.executeQuery();
		          if(rs.next())
		             result=true;
		       }
		          catch (Exception e)
		       {
		          e.printStackTrace();
		       }
		       return result;
		     }
	}

	private Object tackTrace() {
		// TODO Auto-generated method stub
		return null;
	}
	

	public boolean insertAdmin(Admin admin) {
		{
			Connection conn=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			ResultSet rs=null;
			boolean result=false;
			
			try
			{
				conn=DbConnector.getConnection();
				st1=conn.prepareStatement("select seq_admin.nextval from dual");
				rs=st1.executeQuery();
				rs.next();
				int adminid=rs.getInt(1);
				st=conn.prepareStatement("insert into admin(admin_id,firstname,lastname,age,gender,dob,contact_number,alt_contact_number,email_id,password)values(?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, adminid);	
			st.setString(2, admin.getFname());
			st.setString(3, admin.getLname());
			st.setInt(4, Integer.parseInt(admin.getAge()));
			st.setString(5, admin.getGender());
			st.setString(6, admin.getDob());
			st.setString(7, admin.getContact());
			st.setString(8, admin.getAltcontact());
			st.setString(9, admin.getEmail());
			st.setString(10, admin.getPassword());
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

	

		// TODO Auto-generated method stub

	}

}
