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

/**
 * Servlet implementation class RegisterController_Cus
 */
public class RegisterController_Cus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController_Cus() {
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
		String add=request.getParameter("addressline1");
		String add1=request.getParameter("addressline2");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
	Customer customer=new Customer();
	customer.setLname(lname);
	customer.setFname(fname);
	customer.setAge(age);
	customer.setAdd(add);
	customer.setAdd(add1);
	customer.setAltcontact(altcontact);
	customer.setContact(contact);
	customer.setCity(city);
	customer.setState(state);
	customer.setZipcode(zipcode);
	customer.setDob(dob);
	customer.setGender(gender);
	customer.setEmail(email);
	customer.setPassword(password);
	CustomerBO customerbo=new CustomerBO();
	boolean res = customerbo.insertCustomer(customer);
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
			dispatcher=request.getRequestDispatcher("registrationcustomer.jsp");
			request.setAttribute("msg", "Invalid username/password");
			dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}

}
