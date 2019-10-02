package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.User;

public interface IUserService {

	public int addUser(User user) throws SQLException;
	
	//display list
	public ArrayList<User> listUser() throws SQLException;
	
	//update
	public boolean updateUser(int userId, User user) throws SQLException;
	
	//delete
	public boolean deleteUser(int userId) throws SQLException;
	
}//end of interface
