package Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Vehicle;
import Util.myDB;


public class VehicleServiceImplement implements IVehicleService {
	
	private static Connection conn;

	public VehicleServiceImplement() {
		conn = myDB.getDBconection();
	}
	
	@Override
	public boolean addNewVehicle(Vehicle v1) throws SQLException {
		String sql = "Insert into vehicle values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setObject(1, v1.getVehicleID());
		ps.setObject(2, v1.getVehicleNumber());
		ps.setObject(3, v1.getVehicleModel());
		ps.setObject(4, v1.getVehicleBrand());
		ps.setObject(5, v1.getEid());
		
		int res = ps.executeUpdate();
		
		return res > 0;
	}

	@Override
	public ArrayList<Vehicle> getVehicle() throws SQLException {
		String sql = "select*from vehicle";
		Statement stm = conn.createStatement();
		ResultSet rst = stm.executeQuery(sql);
		
		ArrayList<Vehicle> v1List = new ArrayList<Vehicle>();
		
		while(rst.next()) {
			
			Vehicle v1 = new Vehicle();
			
			v1.setVehicleID(rst.getInt("vehicleID"));
			v1.setVehicleNumber(rst.getString("vehicleNumber"));
			v1.setVehicleModel(rst.getString("vehicleModel"));
			v1.setVehicleBrand(rst.getString("vehicleBrand"));
			v1.setEid(rst.getInt("eid"));
			
			v1List.add(v1);
			
		}
		
		return v1List;
	}

	@Override
	public boolean deleteVehicle(int vehicleID) throws SQLException {
		String sql = "delete from vehicle where vehicleID = '"+vehicleID+"'";
		Statement stm = conn.createStatement();
		
		return stm.executeUpdate(sql) > 0;
	}

}



