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
import Service.RegularClientService;

/**
 * Servlet implementation class DeleteRegularClientServlet
 */
@WebServlet("/DeleteRegularClientServlet")
public class DeleteRegularClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRegularClientServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		IRegularClientService iRegularClient = new RegularClientService();
		
		int client_id = Integer.parseInt(request.getParameter("removeClient"));
		
		System.out.println(client_id);
		
		boolean r = false;
		try {
			r = iRegularClient.deleteRegularClient(client_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(r == true){
			System.out.println("Deleted successfully");
			
			out.println("<script>");
			out.println("alert('Regular Client record deleted successfully');");
			out.println("</script>");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListRegularClient.jsp");
			rd.include(request, response);
		}
		else {
			System.out.println("Error occurred");
			
			out.println("<script>");
			out.println("alert('Delete operation failed'); ");
			out.println("</script>");
		}
		
		//doGet(request, response);
	}

}
	

