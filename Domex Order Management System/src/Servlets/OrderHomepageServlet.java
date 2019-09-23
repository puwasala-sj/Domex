package Servlets;

import Model.District;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Model.District;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderHomepageServlet
 */
@WebServlet("/OrderHomepageServlet")
public class OrderHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderHomepageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		response.setContentType("text/html");
		
		
		
		
		/*		List<District> listDistrict = new ArrayList<>();
				
				
				
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 // loads driver
				Connection c;
				try {
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Domex", "root", "root");
					String sql = "SELECT district FROM district"; //ORDER BY vehicleName
					Statement statement = c.createStatement();
					ResultSet result = statement.executeQuery(sql);
					
					
					while (result.next()) {
				
					String name = result.getString("district");
					District district = new District(name);
					
					listDistrict.add(district);
					
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // gets a new connection
				

					
				
				

				request.setAttribute("order", listDistrict);
		
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("Orders.jsp");
				dispatcher.forward(request, response);*/
		
				response.sendRedirect("Orders.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
		
		
	;

	}

}
