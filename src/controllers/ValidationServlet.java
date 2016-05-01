package controllers;

import dbHelpers.Validator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/validate")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get input and validate
		String msg = "";
		String url = "/home.jsp";
		
		// email
				String email = request.getParameter("email");
				if (!Validator.isEmail(email)){
					msg += "The email is not entered correctly.<br />";
					url = "/failedLogin.jsp";
					
					request.setAttribute("msg", msg);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					//response.sendRedirect("/login");
					
					dispatcher.forward(request, response);
					//response.sendRedirect(request.getContextPath() + "/login");
				} else {
				    request.setAttribute("email", email);
				    request.setAttribute("msg", msg);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					//response.sendRedirect("/login");
					
					dispatcher.forward(request, response);
					response.sendRedirect(request.getContextPath() + "/login");
				}
		
		
		
//		// username <= 15 characters	
//		String userName = request.getParameter("userName");
//		if (!Validator.isName(userName)){
//			msg += "The name has not been entered.<br />";
//			url = "/inputErrors.jsp";
//		} else if (!Validator.isShortName(userName)){
//			msg += "The name should be no greater than 15 characters.<br />";
//			url = "/inputErrors.jsp";
//		} else {
//		    request.setAttribute("userName", userName);
//		}
//		
//		// age is a number between 18 and 75
//		try{
//			int age = Integer.parseInt(request.getParameter("age"));
//			if(age < 18 || age > 75){
//				msg += "The age should be between 18 and 75.<br />";
//				url = "/inputErrors.jsp";
//			}
//		} catch (NumberFormatException nfe){
//			msg += "The age should entered as a number.<br />";
//			url = "/inputErrors.jsp";
//		}
//		
////		// date
////		String date = request.getParameter("birthDate");
////		if (!Validator.isDate(date)){
////			msg += "The date is not entered correctly.<br />";
////			url = "/inputErrors.jsp";
////		} else {
////		    request.setAttribute("date", date);
////		}
//		
//		
//		
//		// phone
//		String phone = request.getParameter("phone");
//		if (!Validator.isPhone(phone)){
//			msg += "The phone is not entered correctly.<br />";
//			url = "/inputErrors.jsp";
//		} else {
//		    request.setAttribute("phone", phone);
//		}
//		
//		// url
//		String urlInput = request.getParameter("url");
//		if (!Validator.isURL(urlInput)){
//			msg += "The URL is not entered correctly.<br />";
//			urlInput = "/inputErrors.jsp";
//		} else {
//		    request.setAttribute("url", urlInput);
//		}
		
//		request.setAttribute("msg", msg);
//		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//		//response.sendRedirect("/login");
//		
//		dispatcher.forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/login");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
