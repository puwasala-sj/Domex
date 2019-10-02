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

import Model.RegularClient;
import Model.User;
import Service.IRegularClientService;
import Service.IUserService;
import Service.RegularClientService;
import Service.UserService;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		
		doGet(request, response);
		response.setContentType("text/html");
		
		User user = new User();
		
		//get values
		int userId = Integer.parseInt(request.getParameter("userId"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		int status = Integer.parseInt(request.getParameter("status"));
		
		
		//set object values
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user.setStatus(status);
		
		
		IUserService iuser = new UserService();
		
		boolean validAdd = false; //validation value
		
		try {
			validAdd = iuser.updateUser(userId, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(validAdd == true) { //check
			
			PrintWriter writer= response.getWriter();
			writer.println("<script>");
			writer.println("alert('System User Information Updated Succesfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/ListUser.jsp");
			dispatcher.include(request, response);
					
	}
	}

}
