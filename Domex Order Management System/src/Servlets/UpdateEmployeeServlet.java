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

import Model.Employee;
import Service.IEmployeeService;
import Service.EmployeeServiceImplement;

/**
 * Servlet implementation class UpdateEmployee
 */
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
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
		
		Employee e1 = new Employee();
		
		int employeeID = Integer.parseInt(request.getParameter("employeeID"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String contactNo = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String qualifications = request.getParameter("qualifications");
		String type = request.getParameter("type");
	
		e1.setEmployeeID(employeeID);
		e1.setFname(fname);
		e1.setLname(lname);
		e1.setAddress(address);
		e1.setGender(gender);
		e1.setDob(dob);
		e1.setContactNo(contactNo);
		e1.setEmail(email);
		e1.setQualifications(qualifications);
		e1.setType(type);
		
		IEmployeeService serv = new EmployeeServiceImplement();
		
		boolean isAdded = false;
		try {
			isAdded= serv.updateEmployee(e1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isAdded==true) {
				
				PrintWriter writer= response.getWriter();
				writer.println("<script>");
				writer.println("alert('Updated succesfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/EmployeeList.jsp");
				dispatcher.include(request, response);
						
		}
			
		
	}

}
