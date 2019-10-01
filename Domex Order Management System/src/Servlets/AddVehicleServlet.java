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
import javax.servlet.http.HttpSession;

import Model.Vehicle;
import Service.IVehicleService;
import Service.VehicleServiceImplement;

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
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

		Vehicle vehicle = new Vehicle();
		
		
		String vehicleNumber = request.getParameter("vehicleNumber");
		String vehicleBrand = request.getParameter("vehicleBrand");
		String vehicleModel = request.getParameter("vehicleModel");
		int eid = Integer.parseInt(request.getParameter("eid"));
	
		if(vehicleNumber.equals("") || vehicleBrand.equals("") || vehicleModel.equals("")) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Fill all Details')");
			out.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddVehicle.jsp");
			dispatcher.include(request, response);
		
			
		}
		
		else if(!vehicleNumber.matches("[A-Za-z0-9,]+")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('vehicle Number must be letters and Numbers only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddVehicle.jsp");
			
			dispatcher.include(request, response);
			
		}
		
		else if(!vehicleBrand.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('vehicle brand must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddVehicle.jsp");
			
			dispatcher.include(request, response);
			
		}
		
		else if(!vehicleModel.matches("[A-Za-z0-9,]+")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('vehicle Model must be letters and Numbers only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddVehicle.jsp");
			
			dispatcher.include(request, response);
			
		}
		
		
		
		
		else {
			vehicle.setVehicleNumber(vehicleNumber);
			vehicle.setVehicleModel(vehicleModel);
			vehicle.setVehicleBrand(vehicleBrand);
			vehicle.setEid(eid);
			
			
			
		}
		
		IVehicleService iVehicleService = new VehicleServiceImplement();

		try {
			boolean isadded = iVehicleService.addNewVehicle(vehicle);
			
			if(isadded == true) {	
					System.out.println("Success");
					
					PrintWriter writer = response.getWriter();
					
					writer.println("<script>");
					writer.println("alert('Added Successfully')");
					writer.println("</script>");
					
					HttpSession session1 = request.getSession(); 
				    session1.setAttribute("vehicleNumber", vehicle.getVehicleNumber());
					
				    HttpSession session2 = request.getSession(); 
				    session2.setAttribute("vehicleModel", vehicle.getVehicleModel());
					
				    HttpSession session3 = request.getSession(); 
				    session3.setAttribute("vehicleBrand", vehicle.getVehicleBrand());
				    
				    HttpSession session4 = request.getSession(); 
				    session4.setAttribute("eid", vehicle.getEid());			    
					
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddVehicle.jsp");
					dispatcher.include(request, response);
			}
			else
				System.out.println("Error");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
