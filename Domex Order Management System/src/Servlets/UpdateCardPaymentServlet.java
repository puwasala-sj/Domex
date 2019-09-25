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

import Model.CardPayment;
import Service.IOrderPaymentService;
import Service.IOrderPaymentServiceImplement;

/**
 * Servlet implementation class UpdateCardPaymentServlet
 */
@WebServlet("/UpdateCardPaymentServlet")
public class UpdateCardPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCardPaymentServlet() {
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
		CardPayment ca1 = new CardPayment();
		
		int cardPID = Integer.parseInt(request.getParameter("cardPID"));
		String amount = request.getParameter("amount");
		String cardType = request.getParameter("cardType");
		String cardNumber = request.getParameter("cardNumber");	
		String expiryDate = request.getParameter("expiryDate");
		String ccv = request.getParameter("ccv");
		
		ca1.setCardPID(cardPID);
		ca1.setAmount(amount);
		ca1.setCardType(cardType);
		ca1.setCardNumber(cardNumber);
		ca1.setExpiryDate(expiryDate);
		ca1.setCcv(ccv);
		
		IOrderPaymentService serv = new IOrderPaymentServiceImplement();
		
		try {
			boolean isAdded= serv.updateCardInfo(ca1);
			
			if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/CardList.jsp");
				response.setContentType("text/html;charset=UTF-8");
				dispatcher.include(request, response);
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
