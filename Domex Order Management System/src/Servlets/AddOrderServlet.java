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

import Model.Employee;
import Model.Order;
import Service.EmployeeServiceImplement;
import Service.IEmployeeService;
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
			doGet(request, response);
			
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
						writer.println("alert('Added Successfully')");
						writer.println("</script>");
						
					    HttpSession session = request.getSession(); 
					    session.setAttribute("order", order.getCharge());
						
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PaymentMethod.jsp");
						dispatcher.include(request, response);
				}
				else
					System.out.println("Error");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		

				
			/*	try {
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
		

		
		//request.getParameter("C_name").equals("") ||request.getParameter("Package").equals("") ||request.getParameter("Type").equals("") ||request.getParameter("Type").equals("") ||request.getParameter("kilo").equals("") ||request.getParameter("gram").equals("") || request.getParameter("receiver").equals("") ||
			//	request.getParameter("Address").equals("") ||request.getParameter("District").equals("") || request.getParameter("Town").equals("") || request.getParameter("date").equals("") || request.getParameter("PostCode").equals("") ) {
					


		
		
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
					
					
					
						String query1 = "insert into Order(customer_Name , package , type , weight , receiver , address , district , town , postcode , charges )  values(?,?,?,?,?,?,?,?,?,?)";
					
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
							state.setString(1 , order.getDistrict());
							
						
			
			
				
			
					request.setAttribute("order", order.getCharges());
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("PaymentMethod.jsp");
					dispatcher.forward(request, response);
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		*/
		
		//response.sendRedirect("PaymentMethod.jsp");
			
//			float order = 87;
//			
//		    HttpSession session = request.getSession(); 
//		    session.setAttribute("order", order);
//
//		    response.sendRedirect("PaymentMethod.jsp");
			
		}
	


