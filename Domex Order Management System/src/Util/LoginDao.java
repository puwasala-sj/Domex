package Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.User;

public class LoginDao {
	
	public LoginDao(){}
	
	public String userAuthentication(User user) throws SQLException {
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		//DB connection
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
			
		connection = myDB.getDBconection();
		statement = connection.createStatement();
		
		String query = "select username, cast(aes_decrypt((password,'domex') as char), role, status from login ;";
		resultSet = statement.executeQuery(query);
		
		//get values
		String usernameDB = null;
		String passwordDB = null;
		String roleDB = null;
		int statusDB = 0;
		String result = null;
		
		while(resultSet.next()) {
			usernameDB = resultSet.getString("username");
			passwordDB = resultSet.getString("password");
			roleDB = resultSet.getString("role");
			statusDB = resultSet.getInt("status");
		
		
		
		//filtering
		if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("admin") && statusDB > 0) {
			result = "Admin";
		}//admin login successful
		else if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("operator") && statusDB > 0) {
			result = "Operator";
		}//operator login successful
		else if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("supervisor") && statusDB > 0) {
			result = "Supervisor";
		}//supervisor login successful
		else {
			result = "Invalid User Login";
		}//login failed
		}//end of while loop
		
		return result;
	}//end of user authentication method
	
}//end of loginDao
