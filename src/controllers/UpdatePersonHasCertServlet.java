package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonCertifications;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual personhascertification update to the database", urlPatterns = { "/updatePersonHasCert" })
public class UpdatePersonHasCertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonHasCertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the form data and set up a personhascertification object
		int id = Integer.parseInt(request.getParameter("id"));
		int radioNumber = Integer.parseInt(request.getParameter("radioNumber"));
		String certificationName = request.getParameter("certificationName");
		String isExpired = request.getParameter("isExpired");
		String earnedDate = request.getParameter("earnedDate");
		String renewalDate = request.getParameter("renewalDate");
		
		
		
		PersonCertifications personCertification = new PersonCertifications();
		personCertification.setid(id);
		personCertification.setRadioNumber(radioNumber);
		personCertification.setCertificationName(certificationName);
		personCertification.setIsExpired(isExpired);
		personCertification.setEarnedDate(earnedDate);
		personCertification.setRenewalDate(renewalDate);
		
		
		// create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("ocfr", "root", "0000");
		uq.doUpdatePersonHasCert(personCertification);
		
		// pass control on to the ReadServlet
		String url = "/readPersonHasCert";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}