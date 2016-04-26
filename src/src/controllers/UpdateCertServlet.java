package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Certifications;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual certification update to the database", urlPatterns = { "/updateCert" })
public class UpdateCertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCertServlet() {
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
		// get the form data and set up a Book object
		
		String certificationName = request.getParameter("certificationName");
		int expirationPeriod = Integer.parseInt(request.getParameter("expirationPeriod"));
		String certifyingAgency = request.getParameter("certifyingAgency");
		
		
		Certifications certification = new Certifications();
		certification.setCertificationName(certificationName);
		certification.setExpirationPeriod(expirationPeriod);
		certification.setCertifyingAgency(certifyingAgency);
		
		
		// create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("ofr_model", "root", "password");
		uq.doUpdateCertification(certification);
		
		// pass control on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
