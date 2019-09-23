package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Employee;
import Util.myDB;

public class EmployeeServiceImplement implements IEmployeeService {

	private static Connection conn;

	public EmployeeServiceImplement() {
		conn = myDB.getDBconection();
	}
	
	@Override
	public boolean addNewEmployee(Employee e1) throws SQLException {
		String sql = "Insert into employee values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, e1.getEmployeeID());
		ps.setObject(2, e1.getFname());
		ps.setObject(3, e1.getLname());
		ps.setObject(4, e1.getAddress());
		ps.setObject(5, e1.getGender());
		ps.setObject(6, e1.getDob());
		ps.setObject(7, e1.getContactNo());
		ps.setObject(8, e1.getEmail());
		ps.setObject(9, e1.getQualifications());
		ps.setObject(10, e1.getType());
		
		int res = ps.executeUpdate();
		
		return res > 0;
	}

	@Override
	public ArrayList<Employee> getEmployee() throws SQLException {
		String sql = "select*from employee";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Employee> e1List = new ArrayList<Employee>();
		
		while(rst.next()) {
			
			Employee e1 = new Employee();
			
			e1.setEmployeeID(rst.getInt("employeeID"));
			e1.setFname(rst.getString("fname"));
			e1.setLname(rst.getString("lname"));
			e1.setAddress(rst.getString("address"));
			e1.setGender(rst.getString("gender"));
			e1.setDob(rst.getString("dob"));
			e1.setContactNo(rst.getString("contactNo"));
			e1.setEmail(rst.getString("email"));
			e1.setQualifications(rst.getString("qualifications"));
			e1.setType(rst.getString("type"));
			
			e1List.add(e1);
			
		}
		
		return e1List;
	}

	@Override
	public boolean deleteEmployee(int employeeID) throws SQLException {
		String sql = "delete from employee where employeeID = '"+employeeID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql) > 0;
	}

}
