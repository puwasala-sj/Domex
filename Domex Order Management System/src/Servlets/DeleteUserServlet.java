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

import Service.IRegularClientService;
import Service.IUserService;
import Service.RegularClientService;
import Service.UserService;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		
		PrintWriter out = response.getWriter();
		
		IUserService iuser = new UserService();
		
		int user_id = Integer.parseInt(request.getParameter("removeUser"));
		
		System.out.println(user_id);
		
		boolean r = false;
		
		try {
			r = iuser.deleteUser(user_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end of catch
		
		if(r == true){
			System.out.println("System User Deleted successfully");
			
			out.println("<script>");
			out.println("alert('System User Deleted successfully');");
			out.println("</script>");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListUser.jsp");
			rd.include(request, response);
		}//successful
		else {
			System.out.println("Error occurred");
			
			out.println("<script>");
			out.println("alert('System User Delete Operation Failed'); ");
			out.println("</script>");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListUser.jsp");
			rd.include(request, response);
			
		}//unsuccessful
		
		//doGet(request, response);
	
	}

	}//end of doPost
