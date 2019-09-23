package Servlets;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Order;

/**
 * Servlet implementation class UpdationServlet
 */
@WebServlet("/UpdationServlet")
public class UpdationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdationServlet() {
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
		

		int ID = Integer.parseInt(request.getParameter("ID"));
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
			try {
			Connection con;

			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/domex", "root", "root");

		

			response.setContentType("text/html");
			
			
			String name = request.getParameter("C_name");
	

	
	

	
	
				//order
				Order order = new Order();
				
				//weight
				float weight;
				
				weight = (float) (Float.parseFloat(request.getParameter("kilo")) +((Float.parseFloat(request.getParameter("gram")))/1000.0));
				Date date = null;
				
				//date from string
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} ;
				
				order.setC_name(request.getParameter("C_name"));
				order.setPackage(request.getParameter("Package"));
				order.setType(request.getParameter("Type"));
				order.setWeight(weight);
				order.setReceiver(request.getParameter("receiver"));
				order.setAddress(request.getParameter("Address"));
				order.setDistrict(request.getParameter("District"));
				order.setTown(request.getParameter("Town"));
				order.setDate(date);
				order.setPostCode(Integer.parseInt(request.getParameter("PostCode")));
				
				
				
					String query1 = "UPDATE order SET customer_Name = ? , package ? , type = ? , weight = ? , receiver = ? , address = ? , district = ? , town = ? , postcode = ? , charges = ? ) WHERE orderID = ?";
				
					String query2 = "SELECT charge FROM district WHERE district = ?"; 
					
					
					
					PreparedStatement state = con.prepareStatement(query2);
					ResultSet result = state.executeQuery(query2);
					
					
					Float charge = result.getFloat("charges");
					
					float charges = charge * weight ;
					
					order.setCharges(charges);
					
						
						PreparedStatement statement = con.prepareStatement(query1);
						
						statement.setString(1, order.getC_name());
						statement.setString(2, order.getPackage() );
						statement.setString(3, order.getType());
						statement.setFloat(4,order.getWeight());
						statement.setString(5, order.getReceiver());
						statement.setString(6,order.getAddress() );
						statement.setString(7, order.getDistrict());
						statement.setString(8, order.getTown());
						statement.setInt(9, order.getPostCode());
						statement.setFloat(10, order.getCharges());
						statement.setFloat(11, ID);
						state.setString(1 , order.getDistrict());
						
					
		
		
			
		
				request.setAttribute("order", order.getCharges());
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderList.jsp");
				dispatcher.forward(request, response);
			
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	
	response.sendRedirect("/OrderList.jsp");
	}

}
