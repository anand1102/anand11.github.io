package com.cognizant.edialgonsis.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cognizant.edialgonsis.util.DbConnector;

public class MedicareDAO {

	public boolean insertMedicare(Medicare_Services med) {
		// TODO Auto-generated method stub
		{
			Connection conn=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			ResultSet rs=null;
			boolean result=false;
			
			try
			{
				conn=DbConnector.getConnection();
				st1=conn.prepareStatement("select seq_medical.nextval from dual");
				rs=st1.executeQuery();
				rs.next();
				int medical_id=rs.getInt(1);
				st=conn.prepareStatement("insert into medicare_services(medicare_services_id ,medicare_service,service_description,amount)values(?,?,?,?)");
			st.setInt(1, medical_id);	
			st.setString(2, med.getName());
			st.setString(3, med.getDes());
			st.setInt(4, Integer.parseInt(med.getAmount()));
			
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

	public Medicare_Services fetchMedicare(int id) {
		{
			Connection conn=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			ResultSet rs=null;
			boolean result=false;
			Medicare_Services med=new Medicare_Services();
			try
			{
				conn=DbConnector.getConnection();
				st1=conn.prepareStatement("select * from medicare_services where medicare_services_id=?");
				st1.setInt(1, id);
				rs=st1.executeQuery();
				
				while(rs.next())
				{
					med.setId(rs.getInt(1));
					med.setName(rs.getString(2));
					med.setDes(rs.getString(3));
					med.setAmount(rs.getString(4));
				}
			}
				catch(Exception e )
				{
				e.printStackTrace();
			   }
				
			return med;
	
	}
}

	/**
	 * @param med
	 * @param id
	 * @return
	 */
	public boolean updateMedicare(Medicare_Services med, int id) {
		{
			Connection conn=null;
			PreparedStatement st=null;
			PreparedStatement st1=null;
			ResultSet rs=null;
			boolean result=false;
			
			try
			{
				conn=DbConnector.getConnection();
		
				st=conn.prepareStatement("update medicare_services set medicare_service=?,service_description=?,amount=? where medicare_services_id=?");	
			st.setString(1, med.getName());
			st.setString(2, med.getDes());
			st.setInt(3, Integer.parseInt(med.getAmount()));
			st.setInt(4, med.getId());
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
}



