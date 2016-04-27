package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.DeleteQuery;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet(description = "Deletes a record for a particular person", urlPatterns = { "/deletePerson" })
public class DeletePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonServlet() {
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
		// get the persons radio number
		String radioNumber = request.getParameter("radioNumber");
		
		// create a deleteQuery object
		DeleteQuery dq = new DeleteQuery("ofr_model", "root", "password");
		
		// use deleteQuery to delete the record
		dq.doDeletePerson(radioNumber);
		
		// pass execution on to the ReadServlet
		String url = "/readPerson";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
