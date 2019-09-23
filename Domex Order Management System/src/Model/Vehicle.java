package Model;

public class Vehicle {

	private int vehicleID;
	private String vehicleNumber;
	private String vehicleModel;
	private String vehicleBrand;
	private int eid;
	
	public Vehicle() {
		
	}

	public Vehicle(int vehicleID, String vehicleNumber, String vehicleModel, String vehicleBrand, int eid) {
		super();
		this.vehicleID = vehicleID;
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel = vehicleModel;
		this.vehicleBrand = vehicleBrand;
		this.eid = eid;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

}