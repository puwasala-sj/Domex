package Servlets;

import java.io.IOException;

import Model.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *  implementation class GetOrderServlet
 */
@WebServlet("/GetOrderServlet")
public class GetOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetOrderServlet() {
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
	
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderList.jsp");
		dispatcher.forward(request, response);
	
	
	
		
//		List<Order> Orders = new ArrayList<>();
//	
//	
//	
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//	 // loads driver
//	Connection c;
//	try {
//		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Domex", "root", "root");
//		String sql = "SELECT * FROM order " ; 
//		Statement statement = c.createStatement();
//		ResultSet result = statement.executeQuery(sql);
//		
//		
//		while (result.next()) {
//	
//		int orderID = result.getInt("orderID");	
//		String c_name = result.getString("customer_Name");
//		String package1 = result.getString("package");
//		String type = result.getString("type");
//		Float weight = result.getFloat("weight");
//		String receiver = result.getString("receiver");
//		String  address = result.getString("address");
//		String district = result.getString("district");
//		String town = result.getString("town");
//		int postCode = result.getInt("postCode");
//		Float charges = result.getFloat("charges");
//		
//		Order order = new Order(orderID , c_name , package1 , type , weight , receiver , district , town , address , postCode , charges);
//
//		Orders.add(order);
//		
//		}
//		
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} // gets a new connection
//	
//
//		
//	
//	
//
//	request.setAttribute("orders", Orders);
//	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderList.jsp");
//	dispatcher.forward(request, response);

	}

}
