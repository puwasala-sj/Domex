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

import Model.CashPayment;
import Service.IOrderPaymentService;
import Service.IOrderPaymentServiceImplement;

/**
 * Servlet implementation class UpdateCashPayment
 */
@WebServlet("/UpdateCashPaymentServlet")
public class UpdateCashPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCashPaymentServlet() {
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
		response.setContentType("text/html");
		
		CashPayment c1 = new CashPayment();
		
		int cashPID = Integer.parseInt(request.getParameter("cashPID"));
		String amount = request.getParameter("amount");
		String deliveryDate=request.getParameter("deliveryDate");
		String deliveryAddress = request.getParameter("deliveryAddress");
	
		c1.setCashPID(cashPID);
		c1.setAmount(amount);
		c1.setDeliveryDate(deliveryDate);
		c1.setDeliveryAddress(deliveryAddress);
		
		IOrderPaymentService serv = new IOrderPaymentServiceImplement();
		
		boolean isAdded = false;
		try {
			isAdded= serv.updateCashInfo(c1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/CashList.jsp");
				dispatcher.include(request, response);
						
		}
			
		
	}

}
