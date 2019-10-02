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
 * Servlet implementation class UpdateCorporateClientServlet
 */
@WebServlet("/UpdateCorporateClientServlet")
public class UpdateCorporateClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCorporateClientServlet() {
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
		
		doGet(request, response);
		response.setContentType("text/html");
		
		//create object
		CorporateClient corporateClient = new CorporateClient();
		
		//getvalues
		int clientId = Integer.parseInt(request.getParameter("client_id"));
		String businessName = request.getParameter("Business_Name");
		String addressNo = request.getParameter("H_Number");
		String lane = request.getParameter("Lane");
		String street = request.getParameter("Street");
		String city = request.getParameter("City");
		String province = request.getParameter("Province");
		String email = request.getParameter("Email");
		String emailExtra = request.getParameter("Email_other");
		String contactNo = request.getParameter("Contact_No");
		
		//set values
		corporateClient.setBusinessName(businessName);
		corporateClient.setAddressNo(addressNo);
		corporateClient.setLane(lane);
		corporateClient.setStreet(street);
		corporateClient.setCity(city);
		corporateClient.setProvince(province);
		corporateClient.setEmail(email);
		corporateClient.setExtraEmail(emailExtra);
		corporateClient.setContactNo(contactNo);
		
		ICorporateClient icorpclient = new CorporateClientService();
		
		boolean validUpdate = false;
		
		try {
			validUpdate = icorpclient.updateCorporateClient(clientId, corporateClient);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(validUpdate == true) { //check
			
			PrintWriter writer= response.getWriter();
			writer.println("<script>");
			writer.println("alert('Corporate Client Information Updated Succesfully')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/ListCorporateClient.jsp");
			dispatcher.include(request, response);
					
	}
		
		
	}//end of doPost

}
