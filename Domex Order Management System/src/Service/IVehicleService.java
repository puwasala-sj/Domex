package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Model.Vehicle;

public interface IVehicleService {
	
	boolean addNewVehicle (Vehicle v1) throws SQLException;
	
	public ArrayList<Vehicle> getVehicle() throws SQLException;

	boolean deleteVehicle(int vehicleID) throws SQLException;

	
}
