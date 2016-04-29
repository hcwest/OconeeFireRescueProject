package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.User;
import utilities.PasswordService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new product to the database", urlPatterns = { "/addUser" })
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
		    
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//encrypt
		PasswordService pws = new PasswordService();
		String encryptPass = pws.encrypt(password);
		
		
		// set up a certifications object
	    User user = new User();
	    user.setEmail(email);
	    user.setPassword(encryptPass);
	   
	    
		// set up an addQuery object
	    AddQuery aq = new AddQuery("ocfr", "root", "password");
	    
		// pass the product to addQuery to add to the database
	    aq.doAddUser(user);
	    
		// pass execution control to the ReadServlet
	    String url = "home.jsp";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
		
	}

}
