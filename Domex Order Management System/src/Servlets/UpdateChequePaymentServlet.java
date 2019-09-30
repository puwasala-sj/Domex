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

import Model.ChequePayment;
import Service.IOrderPaymentService;
import Service.IOrderPaymentServiceImplement;

/**
 * Servlet implementation class UpdateChequePayment
 */
@WebServlet("/UpdateChequePaymentServlet")
public class UpdateChequePaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateChequePaymentServlet() {
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
		
		ChequePayment ch1 = new ChequePayment();
		
		int chequePID = Integer.parseInt(request.getParameter("chequePID"));
		String amount = request.getParameter("amount");
		String chequeNumber = request.getParameter("chequeNumber");
		String bank = request.getParameter("bank");
		
		ch1.setChequePID(chequePID);
		ch1.setAmount(amount);
		ch1.setChequeNumber(chequeNumber);
		ch1.setBank(bank);
		
		IOrderPaymentService serv = new IOrderPaymentServiceImplement();
		
		boolean isAdded = false;
		try {
			isAdded= serv.updateChequeInfo(ch1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/ChequeList.jsp");
				dispatcher.include(request, response);
						
		}
	}

}
