package com.cognizant.edialgonsis.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DbConnector {
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
	ResourceBundle rb = ResourceBundle.getBundle("mysql");
    String driver=rb.getString("db.driver");
	String url = rb.getString("db.url");
	String username = rb.getString("db.username");
	String password = rb.getString("db.password");
	/*try {
	conn = DbConnector.getConnection();
	PreparedStatement st=conn.prepareStatement("select * from user_login where username=? and password=?");
	
	st.setString(1, name);
	st.setString(2, password);
	ResultSet rs=st.executeQuery();
	if(rs.next())*/
	Class.forName(driver);
	Connection conn=DriverManager.getConnection(url,username,password);
	return conn;
	}
}
