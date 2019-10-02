package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.CorporateClient;
import Model.RegularClient;
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
	public ArrayList<CorporateClient> listCorporateClients() throws SQLException {
		
		String query = "select * from corporate_client ;";
		statement = connection.createStatement(); //connect
		ResultSet list = statement.executeQuery(query); //execute 
		
		ArrayList<CorporateClient> corpClientList = new ArrayList<CorporateClient>(); //store values
		
		//set attributes - regular client
		while(list.next()){
			CorporateClient corporateClient = new CorporateClient();
			
			corporateClient.setClientId(list.getInt("client_id"));
			corporateClient.setBusinessName(list.getString("business_name"));
			corporateClient.setAddressNo(list.getString("address_no"));
			corporateClient.setLane(list.getString("lane"));
			corporateClient.setStreet(list.getString("street"));
			corporateClient.setCity(list.getString("city"));
			corporateClient.setEmail(list.getString("email"));
			corporateClient.setContactNo(list.getString("contact_no"));
			corporateClient.setProvince(list.getString("province"));
			
			corpClientList.add(corporateClient);
			
		}//end of while loop
		
		
		return corpClientList; //return list
	}

	@Override
	public boolean updateCorporateClient(int clientId, CorporateClient corporateClient) throws SQLException {
		
		String query1 = "update corporate_client set business_name=?, address_no=?, lane=?, street=?, city=?, contact_no=?, province=? where client_id= " + corporateClient.getClientId();
		
		PreparedStatement ps1 = connection.prepareStatement(query1);
		
		ps1.setObject(1, corporateClient.getBusinessName());
		ps1.setObject(2, corporateClient.getAddressNo());
		ps1.setObject(3, corporateClient.getLane());
		ps1.setObject(4, corporateClient.getStreet());
		ps1.setObject(5, corporateClient.getCity());
		ps1.setObject(6, corporateClient.getContactNo());
		ps1.setObject(7, corporateClient.getProvince());
		
		int res1 = ps1.executeUpdate();
		
		//updating email
		String query2 = "update corporate_client_email set email=? where client_id =" + corporateClient.getClientId();
		
		PreparedStatement ps2 = connection.prepareStatement(query2);
		
		ps2.setObject(1, corporateClient.getEmail());
		int res2 = 0;
		res2 = ps2.executeUpdate(); //execute sql
		
		int res3 = 0;
		
		if(corporateClient.getExtraEmail() != null) {
			String query3 = "update corporate_client_email set email=? where client_id= " + corporateClient.getClientId();
			PreparedStatement ps3 = connection.prepareStatement(query3);
			ps3.setObject(1, corporateClient.getExtraEmail());
			
			res3 = ps3.executeUpdate(); //execute sql
		}
		
		if(res1 > 0 && res2 > 0 && res3 > 0) { //two email updated
			return true;
		}
		else if(res1 > 0 && res2 > 0 && res3 == 0) { //no extra email updated
			return true;
		}
		else if(res1 > 0 && res2 == 0 && res3 == 0) { //no email updated
			return true;
		}
		else if(res1 > 0 && res2 == 0 && res3 > 0) { //only extra email updated
			return true;
		}
		else
			return false;
		
		
	}

	@Override
	public boolean deleteCorporateClient(int clientId) throws SQLException {
		
		String query = "delete from corporate_client where client_id =?";
		statement = connection.createStatement();
		
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, clientId);
		
		int result = ps.executeUpdate();
		
		return (result > 0);

	}

}
