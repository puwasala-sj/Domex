package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.CorporateClient;
import Util.myDB;

public class CorporateClientService implements ICorporateClient {
	
	private static Connection connection;
	
	private static Statement statement;
	
	public CorporateClientService(){
		connection = myDB.getDBconection();
	}

	@Override
	public int addCorporateClient(CorporateClient corporateClient) throws SQLException {
		
		String add = "insert into corporate_client(business_name, address_no, lane, street, city, contact_no, province) values (?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement = connection.prepareStatement(add);
		
		preparedStatement.setString(1, corporateClient.getBusinessName());
		preparedStatement.setString(2, corporateClient.getAddressNo());
		preparedStatement.setString(3, corporateClient.getLane());
		preparedStatement.setString(4, corporateClient.getStreet());
		preparedStatement.setString(5, corporateClient.getCity());
		preparedStatement.setString(6, corporateClient.getContactNo());
		preparedStatement.setString(7, corporateClient.getProvince());
		
		int res = preparedStatement.executeUpdate();
		
		String addNext = "insert into corporate_client_email(email) values(?)";
		
		preparedStatement.setString(1, corporateClient.getEmail());
		
		//if extra email exists
		if(corporateClient.getExtraEmail() != null){
			String addEmail = "insert into corporate_client_email(email) values(?)";
			
			preparedStatement.setString(1, corporateClient.getExtraEmail());
			
			int r = preparedStatement.executeUpdate();
		}
		
		
		int result = preparedStatement.executeUpdate();
		
		if(res > 0 && result > 0)
			return 1;
		else
			return -1;
	}

	@Override
	public CorporateClient searchCorporateClient(int clientId) {
		
		return null;
	}

	@Override
	public ArrayList<CorporateClient> listCorporateClients() {
		
		return null;
	}

	@Override
	public CorporateClient updateCorporateClient(int clientId, CorporateClient corporateClient) {
		
		return null;
	}

	@Override
	public void deleteCorporateClient(int clientId) {
		

	}

}
