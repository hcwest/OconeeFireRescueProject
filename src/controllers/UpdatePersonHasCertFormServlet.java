package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dbHelpers.ReadRecordPersonHasCertifications;

/**
 * Servlet implementation class UpdatePersonFormServlet
 */
@WebServlet("/updatePersonHasCertForm")
public class UpdatePersonHasCertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonHasCertFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int radioNumber = Integer.parseInt(request.getParameter("radioNumber"));
		String certificationName = request.getParameter("certificationName");

		// create ReadRecord class
		ReadRecordPersonHasCertifications rr = new ReadRecordPersonHasCertifications("ocfr", "root", "password", radioNumber, certificationName);

		// Use ReadRecord to get the product data
		rr.doReadPersonHasCertification();

		PersonCertifications personCertification = rr.getPersonCertifications();

		// pass Product and control to the updateForm.jsp
		request.setAttribute("personCertification", personCertification);

		String url = "/updatePersonHsCertifications.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
