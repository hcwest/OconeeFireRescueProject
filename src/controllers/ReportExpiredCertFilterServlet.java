package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadQuery;

/**
 * Servlet implementation class reportExpiredCertFilterServlet
 */
@WebServlet("/reportExpiredCertFilter")
public class ReportExpiredCertFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportExpiredCertFilterServlet() {
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
		// Create a ReadQuery helper object
		ReadQuery rq = new ReadQuery("ocfr", "root", "0000");
		
		String certificationName = request.getParameter("certificationName");
		// Get the html table from the REadQuery object
		rq.doExpiredCertsFilter(certificationName);
		String expiredCertsFilter = rq.getExpiredCertsFilter();
		
		// pass execution control to read.jsp along with the table
		request.setAttribute("expiredCertsFilter", expiredCertsFilter);
		String url = "/reportExpiredCertFilter.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
}
	

}