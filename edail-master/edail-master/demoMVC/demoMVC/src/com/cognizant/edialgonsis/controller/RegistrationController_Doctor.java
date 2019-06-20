package com.cognizant.edialgonsis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.edialgonsis.model.Customer;
import com.cognizant.edialgonsis.model.CustomerBO;
import com.cognizant.edialgonsis.model.Doctor;
import com.cognizant.edialgonsis.model.DoctorBO;
import com.cognizant.edialgonsis.model.Medicare_Services;

import java.util.List;

/**
 * Servlet implementation class RegistrationController_Doctor
 */
public class RegistrationController_Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController_Doctor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DoctorBO docbo=new DoctorBO();
		List<Medicare_Services> doclist=docbo.fetchdoc();
		System.out.println(doclist);
		request.setAttribute("doclist", doclist);
		RequestDispatcher dispatcher=null;
		dispatcher=request.getRequestDispatcher("doctorregistration.jsp");
		dispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String contact=request.getParameter("contactnumber");
		String altcontact=request.getParameter("alt_contact_number");
		String email=request.getParameter("email");
		
		String password=request.getParameter("password");
		String add=request.getParameter("addressline1");
		String add1=request.getParameter("addressline2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
		String degree=request.getParameter("degree");
		String speciality=request.getParameter("speciality");
		String workhours=request.getParameter("workhours");
		String hospital_name=request.getParameter("hospital_name");
		int medicare_id=Integer.parseInt(request.getParameter("medicare_Services"));
		System.out.println(medicare_id);
	Doctor doctor=new Doctor();
	doctor.setLname(lname);
	doctor.setFname(fname);
	doctor.setAge(age);
	doctor.setAdd(add);
	doctor.setAdd(add1);
	doctor.setAltcontact(altcontact);
	doctor.setContact(contact);
	doctor.setCity(city);
	doctor.setState(state);
	doctor.setZipcode(zipcode);
	doctor.setDob(dob);
	doctor.setGender(gender);
	doctor.setEmail(email);
	doctor.setPassword(password);
	doctor.setDegree(degree);
	doctor.setSpeciality(speciality);
	doctor.setWorkhours(workhours);
	doctor.setHospital_name(hospital_name);
	doctor.setMedicare_id(medicare_id);
	DoctorBO doctorbo=new DoctorBO();
	boolean res = doctorbo.insertDoctor(doctor);
	RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		if(res)
		{
			dispatcher=request.getRequestDispatcher("DoctorLanding.jsp");
			session.setAttribute("username", fname);
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("Home.jsp");
			request.setAttribute("msg", "Invalid username/password");
			dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}



}
