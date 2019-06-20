package com.cognizant.edialgonsis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognizant.edialgonsis.model.DoctorBO;
import com.cognizant.edialgonsis.model.MedicareBO;
import com.cognizant.edialgonsis.model.Medicare_Services;

/**
 * Servlet implementation class FetchController
 */
public class FetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=null;
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("mid"));
		MedicareBO medbo=new MedicareBO();
		Medicare_Services obj=medbo.fetchMedicare(id);
		System.out.println(obj);
		session.setAttribute("med_obj", obj);
		dispatcher=request.getRequestDispatcher("ListMedicare.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String des=request.getParameter("des");
			String amount=request.getParameter("amount");
			Medicare_Services med=new Medicare_Services();
			RequestDispatcher dispatcher=null;
			med.setId(Integer.parseInt(id));
			med.setName(name);
			med.setDes(des);
			med.setAmount(amount);
			boolean res;
			MedicareBO medbo=new MedicareBO();
			res=medbo.updateMedicare(med,Integer.parseInt(id));
			if(res)
			{
				request.setAttribute("updatemsg", "updated sucessfully");
				
				dispatcher=request.getRequestDispatcher("ListMedicare.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
                request.setAttribute("updatemsg", "Not updateds");
				dispatcher=request.getRequestDispatcher("ListMedicare.jsp");
				dispatcher.forward(request, response);
		}

}
	}
