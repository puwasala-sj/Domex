package Service;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.RegularClient;

public interface IRegularClientService {
	
	public int addRegularClient(RegularClient regularClient) throws SQLException;
	
	//search client
	public RegularClient searchRegularClient(int clientId);
	
	//display list
	public ArrayList<RegularClient> listRegularClients() throws SQLException;
	
	//update
	public boolean updateRegularClient(int clientId, RegularClient regularClient) throws SQLException;
	
	//delete
	public boolean deleteRegularClient(int clientId) throws SQLException;
	
}
