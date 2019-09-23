package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Employee;

public interface IEmployeeService {
	
	boolean addNewEmployee (Employee e1) throws SQLException;
	
	public ArrayList<Employee> getEmployee() throws SQLException;

	boolean deleteEmployee(int employeeID) throws SQLException;

}
