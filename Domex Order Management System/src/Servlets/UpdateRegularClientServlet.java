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

import Model.RegularClient;
import Service.RegularClientService;
import Service.IRegularClientService;

/**
 * Servlet implementation class UpdateRegularClientServlet
 */
@WebServlet("/UpdateRegularClientServlet")
public class UpdateRegularClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRegularClientServlet() {
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
		
		doGet(request, response);
		response.setContentType("text/html");
		
		RegularClient regularClient = new RegularClient();
		
		//get values
		int clientId = Integer.parseInt(request.getParameter("clientId"));
		String firstName = request.getParameter("F_Name");
		String lastName = request.getParameter("L_Name");
		String houseNo = request.getParameter("H_Number");
		String lane = request.getParameter("Lane");
		String street = request.getParameter("Street");
		String town = request.getParameter("Town");
		String city = request.getParameter("City");
		String province = request.getParameter("Province");
		String postalCode = request.getParameter("PostalCode");
		String email = request.getParameter("Email");
		String contactNo = request.getParameter("contact_no");
		String nic = request.getParameter("nic");
		
		//set object values
		regularClient.setFirstName(firstName);
		regularClient.setLastName(lastName);
		regularClient.setAddressNo(houseNo);
		regularClient.setLane(lane);
		regularClient.setStreet(street);
		regularClient.setTown(town);
		regularClient.setCity(city);
		regularClient.setProvince(province);
		regularClient.setPostalCode(postalCode);
		regularClient.setEmail(email);
		regularClient.setContactNo(contactNo);
		regularClient.setNic(nic);
		regularClient.setClientId(clientId);
		
		IRegularClientService iregclient = new RegularClientService();
		
		boolean validAdd = false; //validation value
		
		try {
			validAdd = iregclient.updateRegularClient(clientId, regularClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(validAdd == true) { //check
			
			PrintWriter writer= response.getWriter();
			writer.println("<script>");
			writer.println("alert('Regular Client Information Updated Succesfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/ListRegularClient.jsp");
			dispatcher.include(request, response);
					
	}
		
		
	} //end of doPost

}
