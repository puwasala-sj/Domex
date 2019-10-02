package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import Util.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		//validation
		if(username.isEmpty() || password.isEmpty()) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Enter Username and Password');");
			out.println("location='Login.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
		}//empty fields
		else if(username.matches("[a-zA-Z0-9\\\\._\\\\-]{3,}")) {
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Enter Valid Username conataining at least 3 characters');");
			out.println("location='Login.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
		}//username 
		else if(password.matches("((?=.*\\\\d)(?=.*[a-z])(?=.*[@#$%]).{6,20})")) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Enter A Valid Password');");
			out.println("location='Login.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
			rd.include(request, response);
		}//password
		
		//verification
		User user = new User();
		username = user.getUsername();
		password = user.getPassword();
		
		LoginDao login = new LoginDao();
		
		try {
			String userValidateResult = login.userAuthentication(user); //authenticate user values
		
		
		//session assignment
		if(userValidateResult.equals("admin")) {
			
			System.out.println("Admin's HomePage");
			 
			HttpSession session = request.getSession(); //Creating a session
			session.setAttribute("Admin", username); //setting session attribute
			request.setAttribute("Username", username);
			 
			 request.getRequestDispatcher("Admin.jsp").forward(request, response); //must create admin home page
			 
		}//admin session
		else if(userValidateResult.equalsIgnoreCase("operator")) {
			System.out.println("Operator's HomePage");
			 
			HttpSession session = request.getSession(); //Creating a session
			session.setAttribute("Operator", username); //setting session attribute
			request.setAttribute("Username", username);
			 
			 request.getRequestDispatcher("HomePage.jsp").forward(request, response); //must create operator home page
		}//operator session
		else if(userValidateResult.equalsIgnoreCase("supervisor")) {
			System.out.println("Supervisor's HomePage");
			 
			HttpSession session = request.getSession(); //Creating a session
			session.setAttribute("Supervisor", username); //setting session attribute
			request.setAttribute("Username", username);
			 
			request.getRequestDispatcher("HomePage.jsp").forward(request, response); //must create supervisor home page
		}//supervisor session
		else {
			System.out.println("Error message = "+ userValidateResult);
			 request.setAttribute("errorMessage", userValidateResult);
			 
			 request.getRequestDispatcher("Login.jsp").forward(request, response);
			
		} //invalid user login
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//doGet(request, response);
	}

}
