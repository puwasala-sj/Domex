package Servlets;

import java.io.IOException;


import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import Model.Order;
import Service.IOrderServiceImplement;
import Service.OrderService;


/**
 *  implementation class AddOrderServlet
 */
@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddOrderServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub

		//doGet(request, response);
        Order order = new Order();

		String customer_Name = request.getParameter("customer_Name");
		String packages = request.getParameter("packages");
		String type = request.getParameter("type");
		float weight = (float) (Float.parseFloat(request.getParameter("kilo")) +((Float.parseFloat(request.getParameter("gram")))/1000.0));
		String receiver = request.getParameter("receiver");
		String address = request.getParameter("address");
		String district = request.getParameter("district");
		String town = request.getParameter("town");
		int postCode = Integer.parseInt(request.getParameter("postCode"));
		float charge = weight * 150;
	
		if(customer_Name.equals("") ||packages.equals("") || type.equals("") || receiver.equals("") || address.equals("") || district.equals("") ||town.equals("") ) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Fill all Details')");
			out.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Orders.jsp");
			dispatcher.include(request, response);
		}	
		else if(!customer_Name.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Name must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Orders.jsp");
			dispatcher.include(request, response);
			
		}else if(!packages.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Packages must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Orders.jsp");
			dispatcher.include(request, response);
			
		}
		else if(!type.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Type must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Orders.jsp");
			dispatcher.include(request, response);
	
			
		}
		else if(!town.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
		
			writer.println("<script>");
			writer.println("alert('Town must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Orders.jsp");
			dispatcher.include(request, response);
			
		}
		else {

			
			order.setCustomer_Name(customer_Name);
			order.setPackages(packages);
			order.setType(type);
			order.setWeight(weight);
			order.setReceiver(receiver);
			order.setAddress(address);
			order.setDistrict(district);
			order.setTown(town);
			order.setPostCode(postCode);
			order.setCharge(charge);
			
		}
		
		OrderService iOrderService = new IOrderServiceImplement();

		try {
			boolean isadded = iOrderService.addNewOrder(order);
			
			if(isadded == true) {	
					System.out.println("Success");
					
					PrintWriter writer = response.getWriter();
					
					writer.println("<script>");
					writer.println("alert('Added Successfully')");
					writer.println("</script>");
					
				    HttpSession session = request.getSession(); 
				    session.setAttribute("order", order.getCharge());
					
				    HttpSession session1 = request.getSession(); 
				    session1.setAttribute("customer_Name", order.getCustomer_Name());
					
				    HttpSession session2 = request.getSession(); 
				    session2.setAttribute("packages", order.getPackages());
				    
				    HttpSession session3 = request.getSession(); 
				    session1.setAttribute("type", order.getType());
					
				    HttpSession session4 = request.getSession(); 
				    session2.setAttribute("weight", order.getWeight());
				    
				    HttpSession session5 = request.getSession(); 
				    session1.setAttribute("receiver", order.getReceiver());
					
				    HttpSession session6 = request.getSession(); 
				    session2.setAttribute("address", order.getAddress());
				    
				    HttpSession session7 = request.getSession(); 
				    session1.setAttribute("district", order.getDistrict());
					
				    HttpSession session8 = request.getSession(); 
				    session2.setAttribute("town", order.getTown());
				    
				    HttpSession session9 = request.getSession(); 
				    session1.setAttribute("postCode", order.getPostCode());
				    
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Orders.jsp");
					dispatcher.include(request, response);
			}
			else
				System.out.println("Error");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


