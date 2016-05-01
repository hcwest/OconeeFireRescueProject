package controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.ReadQuery;

/**
 * Servlet implementation class reportListMembersServlet
 */
@WebServlet("/reportListMembers")
public class ReportListMembersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListMembersServlet() {
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
				
				
				
				// Get t he html table from the REadQuery object
			    ResultSet personResults = rq.doListMembers();
				String memberList = rq.getMemberList();
				
			
				// If the "Export" button was clicked, then export as CSV
				// otherwise, we'll print HTML as normal.
				if (null == request.getParameter("export")) {
					// Do CSV
					response.setContentType("text/csv");
					
					// These next two HTTP headers in the response object
					// tell the browser to treat the content as a download, 
					// rather than as something to display.
					response.setHeader("Content-Description", "File Transfer");
					response.setHeader("Content-Disposition", "attachment; filename=books.csv");
					
					// A CSV output helper method, similar to the one we used for 
					// the HTML table.
					memberList = rq.getCSVTable(personResults);
					
					// At this point, we could dispatch to a JSP, but
					// the content we wish to output is already fully generated.
					// Let's just print it instead, and be done.
					response.getOutputStream().print(memberList);
					return;
				} 
				
				
				// pass execution control to read.jsp along with the table
				request.setAttribute("memberList", memberList);
				String url = "/reportListMembers.jsp";
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
	}

}