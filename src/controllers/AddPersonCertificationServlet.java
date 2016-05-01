package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.PersonCertifications;
/**
 * Servlet implementation class AddPersonCertificationServlet
 */
@WebServlet("/addPersonCertification")
public class AddPersonCertificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonCertificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int radioNumber = Integer.parseInt(request.getParameter("radioNumber"));
		String certificationName = request.getParameter("certificationName");
		String isExpired = request.getParameter("isExpired");
		String earnedDate = request.getParameter("earnedDate");
		String renewalDate = request.getParameter("renewalDate");
		
		// set up a certifications object
	    PersonCertifications personCertification = new PersonCertifications();
	    personCertification.setRadioNumber(radioNumber);
	    personCertification.setCertificationName(certificationName);
	    personCertification.setIsExpired(isExpired);
	    personCertification.setEarnedDate(earnedDate);
	    personCertification.setRenewalDate(renewalDate);
	    
		// set up an addQuery object
	    AddQuery aq = new AddQuery("ocfr", "root", "0000");
	    
		// pass the product to addQuery to add to the database
	    aq.doAddPersonCertifications(personCertification);
	    
		// pass execution control to the ReadServlet
	    String url = "/readPersonHasCert";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}