package com.cognizant.edialgonsis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognizant.edialgonsis.util.DbConnector;

public class CustomerDAO {

	public boolean insertCustomer(Customer customer)  {
				{
			Connection conn=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			ResultSet rs=null;
			boolean result=false;
			
			try
			{
				conn=DbConnector.getConnection();
				st1=conn.prepareStatement("select seq_customer.nextval from dual");
				rs=st1.executeQuery();
				rs.next();
				int custid=rs.getInt(1);
				st=conn.prepareStatement("insert into customer(customer_id,firstname,lastname,age,gender,dob,contact_number,alt_contact_number,email_id,password,address_line1,address_line2,city,state,zipcode)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, custid);	
			st.setString(2, customer.getFname());
			st.setString(3, customer.getLname());
			st.setInt(4, Integer.parseInt(customer.getAge()));
			st.setString(5, customer.getGender());
			st.setString(6, customer.getDob());
			st.setString(7, customer.getContact());
			st.setString(8, customer.getAltcontact());
			st.setString(9, customer.getEmail());
			st.setString(10, customer.getPassword());
			st.setString(11, customer.getAdd());
			st.setString(12, customer.getAdd1());
			st.setString(13, customer.getCity());
			st.setString(14, customer.getState());
			st.setString(15, customer.getZipcode());
			
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

	public boolean validateUser(String username, String password) {
		{
		       Connection conn=null;
		       PreparedStatement st=null;
		       ResultSet rs=null;
		       boolean result=false;
		       
		       try
		       {
		           conn=DbConnector.getConnection();
		           st=conn.prepareStatement("select * from customer where email_id=? and password=?");
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
}


