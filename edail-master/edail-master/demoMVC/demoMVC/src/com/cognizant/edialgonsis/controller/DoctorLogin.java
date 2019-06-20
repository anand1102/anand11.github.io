package com.cognizant.edialgonsis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.edialgonsis.model.AdminBO;
import com.cognizant.edialgonsis.model.DoctorBO;

/**
 * Servlet implementation class DoctorLogin
 */
public class DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorLogin() {
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
		DoctorBO doctorbo=new DoctorBO();
		boolean result=doctorbo.validateUser(name,passwd);
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		if(result)
		{
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


