package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Person;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new product to the database", urlPatterns = { "/addPerson" })
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonServlet() {
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
		// get the data from the form on addMember.jsp
	    int radioNumber = Integer.parseInt(request.getParameter("radioNumber"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String position = request.getParameter("position");
		String gender= request.getParameter("gender");
		String dateOfBirth= request.getParameter("dateOfBirth");
		String address= request.getParameter("address");
		String workPhone= request.getParameter("workPhone");
		String mobilePhone= request.getParameter("mobilePhone");
		int stationNumber= Integer.parseInt(request.getParameter("stationNumber"));
		String isActive = request.getParameter("isActive");
	    
		// set up a person object
	    Person person = new Person();
		person.setRadioNumber(radioNumber);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setPosition(position);
		person.setGender(gender);
		person.setDateOfBirth(dateOfBirth);
		person.setAddress(address);
		person.setWorkPhone(workPhone);
		person.setMobilePhone(mobilePhone);
		person.setStationNumber(stationNumber);
		person.setActive(isActive);
	    
		// set up an addQuery object
	    AddQuery aq = new AddQuery("ofr_model", "root", "0000");
	    
		// pass the product to addQuery to add to the database
	    aq.doAddPerson(person);
	    
		// pass execution control to the ReadServlet
	    String url = "/read";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
		
	}

}
