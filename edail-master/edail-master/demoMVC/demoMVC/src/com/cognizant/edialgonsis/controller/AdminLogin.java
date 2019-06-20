package com.cognizant.edialgonsis.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.edialgonsis.model.AdminBO;
import com.cognizant.edialgonsis.model.CustomerBO;
import com.cognizant.edialgonsis.model.DoctorBO;
import com.cognizant.edialgonsis.model.Medicare_Services;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
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
		// TODO Auto-generated method stub
		String name=request.getParameter("email");
		String passwd=request.getParameter("password");
		AdminBO adminbo=new AdminBO();
		boolean result=adminbo.validateUser(name,passwd);
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		if(result)
		{
			DoctorBO docbo=new DoctorBO();
			List<Medicare_Services> medlist=docbo.fetchdoc();
			System.out.println(medlist);
			request.setAttribute("medlist", medlist);
			dispatcher=request.getRequestDispatcher("Home.jsp");
			session.setAttribute("username", name);
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("login.jsp");
			request.setAttribute("msg", "Invalid username/password");
			dispatcher.forward(request, response);
		}
		
	}
}
