package com.cognizant.edialgonsis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.edialgonsis.model.MedicareBO;
import com.cognizant.edialgonsis.model.Medicare_Services;

/**
 * Servlet implementation class Add_Medicare_Controller
 */
public class Add_Medicare_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Medicare_Controller() {
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
		String name=request.getParameter("name");
		String des=request.getParameter("des");
		String amount=request.getParameter("amount");
		Medicare_Services med= new Medicare_Services();
		med.setAmount(amount);
		med.setDes(des);
		med.setName(name);
		MedicareBO medbo= new MedicareBO();
		boolean res;
		res=medbo.insert_Medicare(med);
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		if(res)
		{
			dispatcher=request.getRequestDispatcher("Home.jsp");
			request.setAttribute("medsts","medicare services added sucessfully");
			dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("home.jsp");
			request.setAttribute("medsts","invalid information");
			dispatcher.forward(request, response);
		}
		
		doGet(request, response);
		doGet(request, response);
	}

}
