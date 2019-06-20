package com.cognizant.edialgonsis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cognizant.edialgonsis.util.DbConnector;
import java.util.List;

public class DoctorDAO {

	public boolean validateUser(String username, String passwd) {
		{
		       Connection conn=null;
		       PreparedStatement st=null;
		       ResultSet rs=null;
		       boolean result=false;
		       
		       try
		       {
		           conn=DbConnector.getConnection();
		           st=conn.prepareStatement("select * from doctor where email_id=? and password=?");
		            st.setString(1, username);
		           st.setString(2, passwd);
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

	public boolean insertDoctor(Doctor doctor) {
		
		{
			Connection conn=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			ResultSet rs=null;
			boolean result=false;
			
			try
			{
				conn=DbConnector.getConnection();
				st1=conn.prepareStatement("select seq_doctor.nextval from dual");
				rs=st1.executeQuery();
				rs.next();
				int docid=rs.getInt(1);
				st=conn.prepareStatement("insert into doctor(doctor_id,firstname,lastname,age,gender,dob,contact_number,alt_contact_number,email_id,password,address_line1,address_line2,city,state,zipcode,degree,speciality,work_hours,hospital_name,medicare_service_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			st.setInt(1, docid);	
			st.setString(2, doctor.getFname());
			st.setString(3, doctor.getLname());
			st.setInt(4, Integer.parseInt(doctor.getAge()));
			st.setString(5, doctor.getGender());
			st.setString(6, doctor.getDob());
			st.setString(7, doctor.getContact());
			st.setString(8, doctor.getAltcontact());
			st.setString(9, doctor.getEmail());
			st.setString(10, doctor.getPassword());
			st.setString(11, doctor.getAdd());
			st.setString(12, doctor.getAdd1());
			st.setString(13, doctor.getCity());
			st.setString(14, doctor.getState());
			st.setString(15, doctor.getZipcode());
			st.setString(16, doctor.getDegree());
			st.setString(17, doctor.getSpeciality());
			st.setString(18, doctor.getWorkhours());
			st.setString(19, doctor.getHospital_name());
			st.setInt(20,doctor.getMedicare_id());
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

	public List<Medicare_Services> fetchDoc() {
		
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement st=null;
		List<Medicare_Services> doclist=new ArrayList<>();
		try
		{ 	conn=DbConnector.getConnection();
		st=conn.prepareStatement("select * from medicare_services");
		rs=st.executeQuery();
       while(rs.next())
       {
    	   Medicare_Services u=new Medicare_Services();
    	   u.setId(rs.getInt(1));
    	   u.setName(rs.getString(2));
    	   u.setDes(rs.getString(3));
    	   u.setAmount(rs.getString(4));
    	   doclist.add(u);
    	  }
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return doclist;
		}
	}


