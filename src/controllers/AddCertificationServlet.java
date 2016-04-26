package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Certifications;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new product to the database", urlPatterns = { "/addPerson" })
public class AddCertificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCertificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		String certificationName = request.getParameter("certificationName");
		int expirationPeriod = Integer.parseInt(request.getParameter("expirationPeriod"));
		String certifyingAgency = request.getParameter("certifyingAgency");
		
		// set up a certifications object
	    Certifications certification = new Certifications();
	    certification.setCertificationName(certificationName);
	    certification.setExpirationPeriod(expirationPeriod);
	    certification.setCertifyingAgency(certifyingAgency);
	    
		// set up an addQuery object
	    AddQuery aq = new AddQuery("person", "root", "0000");
	    
		// pass the product to addQuery to add to the database
	    aq.doAddCertification(certification);
	    
		// pass execution control to the ReadServlet
	    String url = "/read";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
		
	}

}
