package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.RegularClient;
import Model.User;
import Util.myDB;

public class UserService implements IUserService {

	private static Connection connection;
	
	private static Statement statement;
	
	public UserService() {
		connection = myDB.getDBconection(); //establish connection
	}
	
	@Override
	public int addUser(User user) throws SQLException {
		
		String query = "insert into login(username, password, role, status) values('?',aes_encrypt('?','domex'),'?',?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRole());
		ps.setInt(4, user.getStatus());
		
		int success = ps.executeUpdate();
		
		return success;
	}

	@Override
	public ArrayList<User> listUser() throws SQLException {
		
		String query = "select * from login ;";
		statement = connection.createStatement(); //connect
		ResultSet list = statement.executeQuery(query); //execute 
		
		ArrayList<User> userList = new ArrayList<User>(); //store values
		
		while(list.next()){
			User user = new User();
			
			user.setUserId(list.getInt("userId"));
			user.setUsername(list.getString("username"));
			user.setPassword(list.getString("password"));
			user.setRole(list.getString("role"));
			user.setStatus(list.getInt("status"));
			
			userList.add(user);
			
		}//end of while loop
				
		return userList; //return list
		
	}

	@Override
	public boolean updateUser(int userId, User user) throws SQLException {
		
		String query = "insert into login(username, password, role, status) values('?',aes_encrypt('?','domex'),'?',?)";
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setObject(1, user.getUsername());
		ps.setObject(2, user.getPassword());
		ps.setObject(3, user.getRole());
		ps.setObject(4, user.getStatus());
		
		int result = ps.executeUpdate();
		
		if(result > 0) {
			return true;
		}
		else
			return false;		
		
	}

	@Override
	public boolean deleteUser(int userId) throws SQLException {
		
		String query = "delete from login where client_id =?";
		statement = connection.createStatement();
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, userId);
		
		int result = ps.executeUpdate();
		
		return (result > 0);
		//return false;
	}

}
