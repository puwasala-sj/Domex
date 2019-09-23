package Servlets;

import java.io.IOException;
import Model.District;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.sql.*;
/**
 * Servlet implementation class UpdateOrderServlet
 */
@WebServlet("/UpdateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		
		List<District> listDistrict = new ArrayList<>();
		
		
		
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
	

		
	int Id = (int) request.getAttribute("btnUpdate");
	
    HttpSession session = request.getSession(); 
    session.setAttribute("Id", Id);

    response.sendRedirect("UpdateOrders.jsp");
	

	request.setAttribute("order", listDistrict);

	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("UpdateOrders.jsp");
	dispatcher.forward(request, response);



		

		
	}

}
