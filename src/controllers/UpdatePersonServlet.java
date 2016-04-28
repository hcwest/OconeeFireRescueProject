package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(description = "Controller which starts the actual book update to the database", urlPatterns = { "/updatePerson" })
public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonServlet() {
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
		
		int radioNumber = Integer.parseInt(request.getParameter("radioNumber"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String position = request.getParameter("position");
		String gender = request.getParameter("gender");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String address = request.getParameter("address");
		String workPhone = request.getParameter("workPhone");
		String mobilePhone = request.getParameter("mobilePhone");
		int stationNumber = Integer.parseInt(request.getParameter("stationNumber"));
		String isActive = request.getParameter("isActive");
		String email = request.getParameter("email");
		
		
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
		person.setEmail(email);
		
		
		
		
		// create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("ocfr", "root", "0000");
		uq.doUpdatePerson(person);
		
		// pass control on to the ReadServlet
		String url = "/readPerson";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
