package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import Model.District;
import Model.Order;
import Service.IOrderServiceImplement;
import Service.OrderService;

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
		//doGet(request, response);
		
response.setContentType("text/html");
		
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
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CashPayment.jsp");
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
					writer.println("alert('Updated Successfully')");
					writer.println("</script>");
					

					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderList.jsp");
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
