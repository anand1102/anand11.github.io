package com.cognizant.edialgonsis.model;

public class AdminBO {
public boolean validateUser(String username,String password)
{
	AdminDAO admindao = new AdminDAO();
	boolean result=admindao.validateUser(username, password);
return result;
}

public boolean insertAdmin(Admin Admin) {
	AdminDAO admindao=new AdminDAO();
	boolean res=admindao.insertAdmin(Admin);
	return res;
	// TODO Auto-generated method stub
	
}

}
