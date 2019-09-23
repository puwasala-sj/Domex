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

import Model.CorporateClient;

import Service.CorporateClientService;
import Service.ICorporateClient;

/**
 * Servlet implementation class AddCorporateClientServlet
 */
@WebServlet("/AddCorporateClientServlet")
public class AddCorporateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCorporateClientServlet() {
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
		
		CorporateClient corporateClient = new CorporateClient();
		
		String businessName = request.getParameter("Business_Name");
		String addressNo = request.getParameter("H_No");
		String lane = request.getParameter("Lane");
		String street = request.getParameter("Street");
		String town = request.getParameter("Town");
		String city = request.getParameter("City");
		String contact_no = request.getParameter("Contact_No");
		String email = request.getParameter("Email");
		String otherEmail = request.getParameter("Email_other");
		
		//filed validation
		if(businessName.isEmpty() || addressNo.isEmpty() || lane.isEmpty() || street.isEmpty() || town.isEmpty() || city.isEmpty() || email.isEmpty() ){
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('Please fill out all the fields');");
			out.println("location='CorporateClientRegistration.jsp');");
			out.println("</script>");
			
			RequestDispatcher req = request.getRequestDispatcher("/CorporateClientRegistration.jsp");
			req.include(request, response);
		} //not successful
		
		else if(!businessName.matches("[A-Za-z0-9,]+")){
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('Please enter a valid name');");
			out.println("location='CorporateClientRegistration.jsp');");
			out.println("</script>");
			
			RequestDispatcher req = request.getRequestDispatcher("/CorporateClientRegistration.jsp");
			req.include(request, response);
		}
		
		else if(!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('Please enter a valid email');");
			out.println("location='CorporateClientRegistration.jsp');");
			out.println("</script>");
			
			RequestDispatcher req = request.getRequestDispatcher("/CorporateClientRegistration.jsp");
			req.include(request, response);
		}
		else if(!addressNo.matches("[A-Za-z0-9,/]+") || !lane.matches("[a-zA-Z0-9]") || !street.matches("[A-Za-z0-9]") || !city.matches("[a-zA-Z]")){
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('Please enter a valid address');");
			out.println("location='CorporateClientRegistration.jsp');");
			out.println("</script>");
			
			RequestDispatcher req = request.getRequestDispatcher("/CorporateClientRegistration.jsp");
			req.include(request, response);
		}
		else if(!contact_no.matches("[0-9]") || contact_no.length() > 10){
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('Please enter a valid contact number');");
			out.println("location='CorporateClientRegistration.jsp');");
			out.println("</script>");
			
			RequestDispatcher req = request.getRequestDispatcher("/CorporateClientRegistration.jsp");
			req.include(request, response);
		}
		
		else {
			
			corporateClient.setBusinessName(businessName);
			corporateClient.setAddressNo(addressNo);
			corporateClient.setLane(lane);
			corporateClient.setStreet(street);
			corporateClient.setCity(city);
			corporateClient.setTown(town);
			corporateClient.setEmail(email);
			corporateClient.setContactNo(contact_no);
			
			if(otherEmail == null){
				corporateClient.setExtraEmail(null);
			}
			else {
				corporateClient.setExtraEmail(otherEmail);
			}
			
			ICorporateClient icorp = new CorporateClientService();
			
			int addCorp;
			try {
			   addCorp = icorp.addCorporateClient(corporateClient);
			
			
			if(addCorp > 0){
				
				System.out.println("Corporate client was added successfully");
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('Corporate Client Registered Successfully')");
				out.println("</script>");
				
				request.setAttribute("success", "Registration Successful!");
				
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("HomePage.jsp");
				dispatch.include(request, response);
				
			}//successful
			else {
				System.out.println("Error occurred. Registration incomplete.");
				
			} //unsuccessful
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//successful
		
		//doGet(request, response);
	}

}
