package com.cognizant.edialgonsis.model;

import java.util.List;



public class DoctorBO {

	public boolean validateUser(String name, String passwd) {
		DoctorDAO doctordao = new DoctorDAO();
		boolean result=doctordao.validateUser(name, passwd);
	return result;
	}

	public boolean insertDoctor(Doctor doctor) {
		DoctorDAO doctordao=new DoctorDAO();
		boolean res=doctordao.insertDoctor(doctor);
		return res;
	}

	public List fetchdoc() {
		DoctorDAO docdao=new DoctorDAO();
		List doclist=docdao.fetchDoc();
		return doclist;
	}



}
