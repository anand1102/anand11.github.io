package com.cognizant.edialgonsis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.edialgonsis.model.Admin;
import com.cognizant.edialgonsis.model.AdminBO;
import com.cognizant.edialgonsis.model.Customer;
import com.cognizant.edialgonsis.model.CustomerBO;

/**
 * Servlet implementation class RegistrationController_Admin
 */
public class RegistrationController_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String age=request.getParameter("age");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String contact=request.getParameter("contactnumber");
		String altcontact=request.getParameter("alt_contact_number");
		String email=request.getParameter("email");
		
		String password=request.getParameter("password");
		
Admin admin=new Admin();
	admin.setLname(lname);
	admin.setFname(fname);
	admin.setAge(age);
	admin.setAltcontact(altcontact);
	admin.setContact(contact);
	admin.setDob(dob);
	admin.setGender(gender);
	admin.setEmail(email);
	admin.setPassword(password);
	AdminBO adminbo=new AdminBO();
	boolean res = adminbo.insertAdmin(admin);
	RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		if(res)
		{
			dispatcher=request.getRequestDispatcher("Home.jsp");
			session.setAttribute("username", fname);
			
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("registrationadmin.jsp");
			request.setAttribute("msg", "Invalid username/password");
			dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}
	}


