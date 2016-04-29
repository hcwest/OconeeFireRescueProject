package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dbHelpers.ReadRecordPerson;

/**
 * Servlet implementation class UpdatePersonFormServlet
 */
@WebServlet("/updatePersonForm")
public class UpdatePersonFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonFormServlet() {
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

		// create ReadRecord class
		ReadRecordPerson rr = new ReadRecordPerson("ocfr", "root", "password", radioNumber);

		// Use ReadRecord to get the product data
		rr.doReadPerson();

		Person person = rr.getPerson();

		// pass Product and control to the updateForm.jsp
		request.setAttribute("person", person);

		String url = "/updatePerson.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
