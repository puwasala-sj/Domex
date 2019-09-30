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

import Model.Employee;
import Service.EmployeeServiceImplement;
import Service.IEmployeeService;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
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
        Employee employee = new Employee();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String dob = request.getParameter("dob");
		String contactNo = request.getParameter("contactNo");
		String email = request.getParameter("email");
		String qualifications = request.getParameter("qualifications");
		String type = request.getParameter("type");
	
		if(fname.equals("") ||lname.equals("") || address.equals("") || gender.equals("") || contactNo.equals("") || email.equals("") ||qualifications.equals("") || type.equals("")) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('Fill all Details')");
			out.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.include(request, response);
		}	
		else if(!fname.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('First name must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.include(request, response);
			
		}else if(!lname.matches("^[a-zA-Z]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Last name must be letters only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.include(request, response);
			
		}
		else if(!address.matches("[A-Za-z0-9,/]+")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Address can be contain only letters,numbers, / and ,')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.include(request, response);
			
		} 
		
		 //Gender radio button
		
		else if(!contactNo.matches("^[0-9]+$")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Contact number must be numbers only')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.include(request, response);
			
		}
		else if(!email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")){
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('Please enter a valid email');");
			out.println("location='CorporateClientRegistration.jsp');");
			out.println("</script>");
			
			RequestDispatcher req = request.getRequestDispatcher("/CorporateClientRegistration.jsp");
			req.include(request, response);
			}
			
		else if(!qualifications.matches("[A-Za-z0-9,/]+")) {
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Qualification can be contain only letters,numbers, / and ,')");
			writer.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
			dispatcher.include(request, response);
			
		} 
		
		
		
		else {
			employee.setFname(fname);
			employee.setLname(lname);
			employee.setAddress(address);
			employee.setGender(gender);
			employee.setDob(dob);
			employee.setContactNo(contactNo);
			employee.setEmail(email);
			employee.setQualifications(qualifications);
			employee.setType(type);
			
		}
		
		IEmployeeService iEmployeeService = new EmployeeServiceImplement();

		try {
			boolean isadded = iEmployeeService.addNewEmployee(employee);
			
			if(isadded == true) {	
					System.out.println("Success");
					
					PrintWriter writer = response.getWriter();
					
					writer.println("<script>");
					writer.println("alert('Added Successfully')");
					writer.println("</script>");
					
					HttpSession session1 = request.getSession(); 
				    session1.setAttribute("fname", employee.getFname());
					
				    HttpSession session2 = request.getSession(); 
				    session1.setAttribute("lname", employee.getLname());
					
				    HttpSession session3 = request.getSession(); 
				    session2.setAttribute("address", employee.getAddress());
				    
				    HttpSession session4 = request.getSession(); 
				    session2.setAttribute("gender", employee.getGender());
				    
				    HttpSession session5 = request.getSession(); 
				    session2.setAttribute("dob", employee.getDob());
				    
				    HttpSession session6 = request.getSession(); 
				    session2.setAttribute("contactNo", employee.getContactNo());
				    
				    HttpSession session7 = request.getSession(); 
				    session2.setAttribute("email", employee.getEmail());
				    
				    HttpSession session8 = request.getSession(); 
				    session2.setAttribute("qualifications", employee.getQualifications());
				    
				    HttpSession session9 = request.getSession(); 
				    session2.setAttribute("type", employee.getType());	    
				
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AddEmployee.jsp");
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


