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

import Model.User;
import Service.IUserService;
import Service.UserService;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		User user = new User();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String status = request.getParameter("status");
		
		System.out.println(username + " " + password + " " + role + " " + status );
		
		//validation
		if(username.isEmpty() || password.isEmpty() || role.isEmpty() || status.isEmpty()) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please Fill Out All The Required Fields');");
			out.println("location='AddUser.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/AddUser.jsp");
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
		else {
			
			user.setUsername(username);
			user.setPassword(password);
			user.setRole(role);
			if(status.equals("active")) {
				user.setStatus(1);
			} else
				user.setStatus(0);
			
			IUserService iuser = new UserService();
			
			int addNew;
			try {
				addNew = iuser.addUser(user);
		
			if(addNew > 0 ) {
				
				System.out.println("New System User Successfully Added");
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('New System User Successfully Added')");
				out.println("</script>");
				
				request.setAttribute("success", "Registration Successful!");
				
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/ListUser.jsp");
				dispatch.include(request, response);
				
			}
			else {
				System.out.println("Error occured");
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}//successful
		
		
		//doGet(request, response);
	}

}
