package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import dbHelpers.ReadRecordCertifications;

/**
 * Servlet implementation class UpdatePersonFormServlet
 */
@WebServlet("/updateCertForm")
public class UpdateCertFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCertFormServlet() {
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
		String certificationName = request.getParameter("certificationName");

		// create ReadRecord class
		ReadRecordCertifications rr = new ReadRecordCertifications("ocfr", "root", "password", certificationName);

		// Use ReadRecord to get the product data
		rr.doReadCertification();

		Certifications certification = rr.getCertification();

		// pass Product and control to the updateForm.jsp
		request.setAttribute("certification", certification);

		String url = "/updateCertification.jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
