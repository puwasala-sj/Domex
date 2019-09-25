package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class GetChequePaymentInfoServlet
 */
@WebServlet("/GetChequePaymentInfoServlet")
public class GetChequePaymentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetChequePaymentInfoServlet() {
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

		try {
 		int chequePID = Integer.parseInt(request.getParameter("updateCheque"));			
 		IOrderPaymentService service = new IOrderPaymentServiceImplement();
			ArrayList<ChequePayment> list = service.getChequePaymentInfo(chequePID);
			request.setAttribute("chequepayment", list);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/UpdateChequePaymentInfo.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
