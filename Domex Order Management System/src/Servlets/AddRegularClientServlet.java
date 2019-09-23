package Servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.RegularClient;

import Service.IRegularClientService;
import Service.RegularClientService;

/**
 * Servlet implementation class AddRegularClientServlet
 */
@WebServlet("/AddRegularClientServlet")

public class AddRegularClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRegularClientServlet() {
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
		
		RegularClient regularClient = new RegularClient();
		
		String firstName = request.getParameter("F_Name");
		String lastName = request.getParameter("L_Name");
		String nic = request.getParameter("nic");
		String addressNo = request.getParameter("H_Number");
		String lane = request.getParameter("Lane");
		String street = request.getParameter("Street");
		String town = request.getParameter("Town");
		String city = request.getParameter("City");
		String postalCode = request.getParameter("PostalCode");
		String email = request.getParameter("Email");
		String province = request.getParameter("Province");
		String contact_no = request.getParameter("contact_no");
		
		System.out.println(firstName + " " + lastName + " " +nic + " " + addressNo + " " + lane +" " + street +" " + town +" " + city +" " +postalCode +" " + email +" " + contact_no +" " + province );
		
		
		
		//validation
		
		
		if(lastName.isEmpty() || nic.isEmpty() || email.isEmpty() || city.isEmpty() || contact_no.isEmpty()){
						
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please fill out all the required fields');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
			
		} //not successful
		/*else if(!firstName.matches("``[a-zA-Z]+$`" ) || !lastName.matches("``[a-zA-Z]+$`" )){
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Name should be letters only');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
			
			
		}*/
		else if(!nic.matches("[0-9]{9}[x|X|v|V]$" )){
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('NIC should be digits only');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
			
			
		}
		else if( !postalCode.matches("^\\d{5}$")){
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter a valid postal code');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
			
			
		}
		else if(!lane.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$" ) || !street.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$" ) || !town.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$" ) || !city.matches("^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$" )){
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter a valid address');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
			
			
		}
		else if(!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter a valid email address');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
		}
		
		/*else if(!contact_no.matches("0((11)|(2(1|[3-7]))|(3[1-8])|(4(1|5|7))|(5(1|2|4|5|7))|(6(3|[5-7]))|([8-9]1))([2-4]|5|7|9)[0-9]{6}") || !contact_no.matches("07[1,2,5,6,7,8][0-9]+")){
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Please enter a valid contact number');");
			out.println("location='client_registration.jsp';");
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/client_registration.jsp");
			rd.include(request, response);
			
		}*/
		
		else {
			
			regularClient.setFirstName(firstName);
			regularClient.setLastName(lastName);
			regularClient.setNic(nic);
			regularClient.setAddressNo(addressNo);
			regularClient.setLane(lane);
			regularClient.setStreet(street);
			regularClient.setTown(town);
			regularClient.setCity(city);
			regularClient.setPostalCode(postalCode);
			regularClient.setEmail(email);
			regularClient.setProvince(province);
			regularClient.setContactNo(contact_no);
			
			IRegularClientService iRegularClientService = new RegularClientService();
			
			int addNew;
			try {
				addNew = iRegularClientService.addRegularClient(regularClient);
		
			
			if(addNew > 0 ) {
				
				System.out.println("Successful regualar client registration");
				
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('Regular Client Registered Successfully')");
				out.println("</script>");
				
				request.setAttribute("success", "Registration Successful!");
				
				RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/ListRegularClient.jsp");
				dispatch.include(request, response);
				
			}
			else {
				System.out.println("Error occured");
			}
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
							
		}//successful
			
		//doGet(request, response);
	}

}
