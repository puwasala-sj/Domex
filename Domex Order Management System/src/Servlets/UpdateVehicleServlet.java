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

import Model.Vehicle;
import Service.IVehicleService;
import Service.VehicleServiceImplement;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateVehicleServlet")
public class UpdateVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleServlet() {
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
		
		Vehicle v1 = new Vehicle();
		
		int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));

		String vehicleNumber = request.getParameter("vehicleNumber");
		String vehicleBrand = request.getParameter("vehicleBrand");
		String vehicleModel = request.getParameter("vehicleModel");
		int eid = Integer.parseInt(request.getParameter("eid"));
		
		v1.setVehicleID(vehicleID);
		v1.setVehicleNumber(vehicleNumber);
		v1.setVehicleModel(vehicleModel);
		v1.setVehicleBrand(vehicleBrand);
		v1.setEid(eid);
		
		
		IVehicleService serv = new VehicleServiceImplement();
		
		boolean isAdded = false;
		try {
			isAdded= serv.updateVehicle(v1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/VehicleList.jsp");
				dispatcher.include(request, response);
						
		}
			
		
	}

}
