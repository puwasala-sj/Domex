package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.CorporateClient;

public interface ICorporateClient {

public int addCorporateClient(CorporateClient corporateClient) throws SQLException;
	
	//search client
	public CorporateClient searchCorporateClient(int clientId);
	
	//display list
	public ArrayList<CorporateClient> listCorporateClients() throws SQLException;
	
	//update
	public boolean updateCorporateClient(int clientId, CorporateClient corporateClient) throws SQLException;
	
	//delete
	public boolean deleteCorporateClient(int clientId) throws SQLException;
	
	
}
